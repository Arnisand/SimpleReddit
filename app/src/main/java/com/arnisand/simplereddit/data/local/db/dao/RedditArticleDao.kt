package com.arnisand.simplereddit.data.local.db.dao

import androidx.room.Dao
import com.arnisand.simplereddit.data.local.db.base.BaseDao
import com.arnisand.simplereddit.domain.model.entity.RedditArticleEntity

@Dao
abstract class RedditArticleDao : BaseDao<RedditArticleEntity> {
}