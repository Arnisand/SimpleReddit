package com.arnisand.simplereddit.data.network.adapter

import io.reactivex.Observable
import java.io.IOException
import java.lang.reflect.Type

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class RxErrorHandlingCallAdapterFactory private constructor(): CallAdapter.Factory() {

    private val original by lazy {
        RxJava2CallAdapterFactory.create()
    }

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *> {
        val wrapped = original.get(returnType, annotations, retrofit) as CallAdapter<out Any, *>
        return RxCallAdapterWrapper(wrapped)
    }

    private class RxCallAdapterWrapper<R>(
        val wrappedCallAdapter: CallAdapter<R, *>
    ) : CallAdapter<R, Observable<R>> {

        override fun responseType(): Type = wrappedCallAdapter.responseType()

        @Suppress("UNCHECKED_CAST")
        override fun adapt(call: Call<R>): Observable<R> {
            val adapted = (wrappedCallAdapter.adapt(call) as Observable<R>)
            adapted.onErrorResumeNext { throwable: Throwable ->
                Observable.error(asRetrofitException(throwable))
            }
            return adapted
        }

        private fun asRetrofitException(throwable: Throwable): GeneralCauseError {
            // We had non-200 http error
            if (throwable is HttpException) {
                return throwable.response()?.let { response ->
                    when (response.code()) {
                        400 -> Validation()
                        401 -> Unauthorised()
                        403 -> Denied()
                        404 -> NotFound()
                        422 -> Serialization()
                        500, 503 -> ServerUnavailable()
                        else -> Unexpected()
                    }
                } ?: Unexpected()
            }

            if (throwable is IOException) {
                return com.arnisand.simplereddit.data.network.adapter.IOException()
            }

            return Unexpected()
        }

    }

    companion object {
        fun create(): CallAdapter.Factory = RxErrorHandlingCallAdapterFactory()
    }
}
