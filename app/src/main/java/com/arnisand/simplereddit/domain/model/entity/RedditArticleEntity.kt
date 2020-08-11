package com.arnisand.simplereddit.domain.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "reddit_article")
data class RedditArticleEntity(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "published_date") val publishedDate: Date,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "comment_count") val commentCount: Int
)