package com.example.justplanit

import androidx.room.*

@Dao
interface GetSqlData {

    //Aktivität
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insAktivitaet(aktivitaet: Aktivitaet)

    @Query("SELECT id FROM Aktivitaet WHERE Bezeichnung=:string LIMIT 1")
    fun selAktivitaet(string:String): Int

    @Query("SELECT bezeichnung FROM Aktivitaet WHERE id=:id LIMIT 1")
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

    @Query("SELECT * FROM Fortschritt WHERE metrik=:metrik AND aktivitaet=:aktivitaet")
    fun selFortschritte(metrik:Int, aktivitaet:Int): List<Fortschritt>

    //Metrik
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insMetrik(metrik: Metrik)

    @Query("SELECT id FROM Metrik WHERE einheit=:string LIMIT 1")
    fun selMetrik(string:String): Int

    @Query("SELECT einheit FROM Metrik WHERE id=:id LIMIT 1")
    fun selMetrik(id:Int): String

    @Query("SELECT * FROM Metrik")
    fun selMetrik():  List<Metrik>

    //Vorsatz
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insVorsatz(vorsatz: Vorsatz)

    @Query("UPDATE Vorsatz SET aktiv = 0 WHERE ID=:id")
    fun delVorsatz(id: Int)

    @Query("SELECT * FROM Vorsatz WHERE aktiv = 1")
    fun selVorsatz():  List<Vorsatz>

    @Query("SELECT * FROM Vorsatz WHERE id=:id LIMIT 1")
    fun selVorsatz(id:Int): Vorsatz

    //Intervall
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insIntervall(intervall: Intervall)

    @Query("SELECT * FROM Intervall")
    fun selIntervall():  List<Intervall>

    @Query("SELECT id FROM Intervall WHERE anzahl || ' ' || bezeichnung =:string LIMIT 1")
    fun selIntervall(string:String): Int

    @Query("SELECT anzahl || ' ' || bezeichnung  FROM Intervall WHERE id=:id LIMIT 1 ")
    fun selIntervall(id:Int): String
}