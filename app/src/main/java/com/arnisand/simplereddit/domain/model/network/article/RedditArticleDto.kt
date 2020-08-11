package com.arnisand.simplereddit.domain.model.network.article

import java.util.*

data class RedditArticleDto(
    val name: String,
    val title: String,
    val author: String,
    val publishedDate: Date,
    val image: String,
    val commentCount: Int
)