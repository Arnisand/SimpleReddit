package com.arnisand.simplereddit.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arnisand.simplereddit.data.local.db.convertor.DateConvertors
import com.arnisand.simplereddit.data.local.db.dao.RedditArticleDao
import com.arnisand.simplereddit.domain.model.entity.RedditArticleEntity

@Database(entities = [RedditArticleEntity::class], version = 1)
@TypeConverters(DateConvertors::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun redditArticleDao(): RedditArticleDao
}
