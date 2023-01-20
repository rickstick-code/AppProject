package com.example.justplanit

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class Converter {
    //TODO - Gibt er bei falsch wirklich null raus?
        @TypeConverter
        fun stringToDate(date: String): Date? {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN)
        return try {
            formatter.parse(date)
        } catch(e: java.lang.Exception) {
            null
        }
        }

        @TypeConverter
        fun dateToString(date: Date) : String {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.GERMAN)
            return format.format(date)
        }
}