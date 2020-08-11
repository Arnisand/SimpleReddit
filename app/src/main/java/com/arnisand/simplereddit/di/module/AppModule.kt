package com.arnisand.simplereddit.di.module

import android.app.Application
import androidx.room.Room
import com.arnisand.simplereddit.BuildConfig.BASE_URL
import com.arnisand.simplereddit.data.local.db.AppDatabase
import com.arnisand.simplereddit.data.network.RedditDataSource
import com.arnisand.simplereddit.data.network.adapter.RxErrorHandlingCallAdapterFactory
import com.arnisand.simplereddit.domain.model.network.article.RedditArticleDto
import com.arnisand.simplereddit.domain.model.network.article.RedditArticleListDeserializer
import com.arnisand.simplereddit.domain.model.network.article.RedditTopArticleAnswer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(applicationContext: Application): AppDatabase {
        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "photon_lms_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providesRedditApiService(): RedditDataSource {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(createGsonConverter())
            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
            .client(OkHttpClient())
            .build()

        return retrofit.create(RedditDataSource::class.java)
    }

    private fun createGsonConverter(): Converter.Factory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(RedditTopArticleAnswer::class.java, RedditArticleListDeserializer())
        val gson = gsonBuilder.create()
        return GsonConverterFactory.create(gson)
    }
}
