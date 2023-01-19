package com.example.justplanit

import androidx.room.*

@Dao
interface GetSqlData {

    //Aktivität
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insAktivitaet(aktivitaet: Aktivitaet)

    @Query("SELECT id FROM Aktivitaet WHERE Bezeichnung=:string LIMIT 1 ")
    fun selAktivitaet(string:String): Int

    @Query("SELECT bezeichnung FROM Aktivitaet WHERE id=:id LIMIT 1 ")
    fun selAktivitaet(id:Int): String

    @Query("SELECT * FROM Aktivitaet")
    fun selAktivitaet(): List<Aktivitaet>

    //Fortschritt
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insFortschritt(fortschritt: Fortschritt)

    @Query("DELETE FROM Fortschritt WHERE ID=:id")
    fun delFortschritt(id:String)

    @Query("SELECT * FROM Fortschritt")
    fun selFortschritte(): List<Fortschritt>

    //Metrik
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insMetrik(metrik: Metrik)

    @Query("SELECT id FROM Metrik WHERE einheit=:string LIMIT 1 ")
    fun selMetrik(string:String): Int

    @Query("SELECT einheit FROM Metrik WHERE id=:id LIMIT 1 ")
    fun selMetrik(id:Int): String

    @Query("SELECT * FROM Metrik")
    fun selMetrik():  List<Metrik>

    //Vorsatz
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insVorsatz(vorsatz: Vorsatz)

    @Query("SELECT * FROM Vorsatz")
    fun selVorsatz():  List<Vorsatz>
}