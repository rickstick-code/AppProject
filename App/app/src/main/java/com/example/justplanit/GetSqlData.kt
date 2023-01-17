package com.example.justplanit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GetSqlData {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insAktivitaet(aktivitaet: Aktivitaet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insFortschritt(fortschritt: Fortschritt)

    @Query("SELECT * FROM Fortschritt")
    fun selFortschritt(): List<Fortschritt>
}