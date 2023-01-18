package com.example.justplanit

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converter {
        @TypeConverter
        fun stringToDate(date: String): Date {
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            return formatter.parse(date)!!
        }

        @TypeConverter
        fun dateToString(date: Date) : String {
            val format = SimpleDateFormat("yyyy-MM-dd")
            return format.format(date)
        }
}