package com.example.justplanit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Aktivitaet::class], version = 1)
abstract class SqlDatabase : RoomDatabase() {
    abstract val getSqlData: GetSqlData

    companion object {
        private var INSTANCE: SqlDatabase? = null
        fun getDatabase(context: Context): SqlDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): SqlDatabase {
            return Room.databaseBuilder(
                context,
                SqlDatabase::class.java, "sql-db"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}