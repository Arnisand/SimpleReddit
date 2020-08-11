package com.arnisand.simplereddit.data.local.db.convertor

import androidx.room.TypeConverter
import java.util.*

class DateConvertors {

    @TypeConverter
    fun toDate(time: Long) = Date(time)

    @TypeConverter
    fun fromDate(date: Date) = date.time
}