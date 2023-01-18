package com.example.justplanit

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converter {
        @TypeConverter
        fun fromTimestamp(value: Long?): Date? {
            return value?.let { Date(it) }
        }

        @TypeConverter
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time?.toLong()
        }

        fun toSimpleString(date: Date) : String {
            val format = SimpleDateFormat("dd/MM/yyy")
            return format.format(date)
        }
}