package com.example.justplanit

import androidx.room.*

@Dao
interface GetSqlData {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insAktivitaet(aktivitaet: Aktivitaet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insFortschritt(fortschritt: Fortschritt)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insMetrik(metrik: Metrik)

    @Query("DELETE FROM Fortschritt WHERE ID=:id")
    fun delFortschritt(id:String)

    @Query("SELECT * FROM Fortschritt")
    fun selFortschritte(): List<Fortschritt>

    @Query("SELECT id FROM Metrik WHERE Bezeichnung=:string LIMIT 1 ")
    fun selMetrik(string:String): Int
}