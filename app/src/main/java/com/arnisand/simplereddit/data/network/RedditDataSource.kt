package com.arnisand.simplereddit.data.network

import com.arnisand.simplereddit.domain.model.network.article.RedditTopArticleAnswer
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditDataSource {

    @GET("top.json")
    fun getTopArticlesAsync(
        @Query("after") after: String,
        @Query("before") before: String,
        @Query("limit") limit: Int,
        @Query("count") count: Int
    ): Observable<RedditTopArticleAnswer>
}