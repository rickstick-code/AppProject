package com.example.justplanit

import android.content.Context
import java.util.*

class ExampleData(var context: Context) {

    fun create() {
        if(SqlDatabase.getDatabase(context).getSqlData.selAktivitaet().isNotEmpty()){return}

        fortschritt("2022-10-10", 3, 10, 1)
        fortschritt("2022-10-11", 8, 11, 2)
        fortschritt("2022-10-12", 7, 12, 3)
        fortschritt("2022-10-12", 2, 20, 5)
        fortschritt("2022-10-12", 5, 1, 6)
        fortschritt("2022-10-12", 1, 5, 7)

        vorsatz("Fit werden",1,3,"2022-12-01", 100, 1, true)
        vorsatz("Richtig Fit werden",2,3,"2022-12-01", 200, 2, true)
        vorsatz("Hammer werden",5,3,"2022-02-01", 150, 7, true)

        aktivitaet("Gesund Essen")
        aktivitaet("Handy Fasten")
        aktivitaet("Laufen")
        aktivitaet("Lernen")
        aktivitaet("Meditieren")
        aktivitaet("Trainieren")
        aktivitaet("Trinken")
        aktivitaet("Wandern")

        metrik(context.getString(R.string.meters), "m")
        metrik(context.getString(R.string.kilometers), "km")
        metrik(context.getString(R.string.liters), "l")
        metrik(context.getString(R.string.seconds), "s")
        metrik(context.getString(R.string.minutes), "min")
        metrik(context.getString(R.string.hours), "h")
        metrik(context.getString(R.string.times), "X")

        intervall(context.getString(R.string.hour),1)
        intervall(context.getString(R.string.day),1)
        intervall(context.getString(R.string.day),2)
        intervall(context.getString(R.string.week),1)
        intervall(context.getString(R.string.week),2)
        intervall(context.getString(R.string.week),3)
        intervall(context.getString(R.string.week),4)
        intervall(context.getString(R.string.month),1)
        intervall(context.getString(R.string.month),5)
        intervall(context.getString(R.string.month),10)

        achievement(context.getString(R.string.a_progress_1),"SELECT COUNT(*) FROM Fortschritt")
        achievement(context.getString(R.string.a_progress_10),"SELECT COUNT(*)-9 FROM Fortschritt")
        achievement(context.getString(R.string.a_progress_100),"SELECT COUNT(*)-99 FROM Fortschritt")
        achievement(context.getString(R.string.a_resolution_1),"SELECT COUNT(*) FROM Vorsatz")
        achievement(context.getString(R.string.a_resolution_5),"SELECT COUNT(*)-4 FROM Vorsatz")
        achievement(context.getString(R.string.a_resolution_10),"SELECT COUNT(*)-9 FROM Vorsatz")
        achievement(context.getString(R.string.a_drinking),"SELECT COUNT(*) FROM Vorsatz WHERE aktivitaet=7")

    }

    fun metrik(bezeichnung:String, einheit:String){
        SqlDatabase.getDatabase(context).getSqlData.insMetrik(Metrik(bezeichnung = bezeichnung, einheit = einheit))
    }

    fun fortschritt(datum:String, aktivitaet:Int, zielmenge:Int, metrik: Int){
        SqlDatabase.getDatabase(context).getSqlData.insFortschritt(Fortschritt(datum = Converter().stringToDate(datum) ?: Date(), aktivitaet = aktivitaet, zielmenge = zielmenge, metrik = metrik))
    }

    fun aktivitaet(bezeichnung:String){
        SqlDatabase.getDatabase(context).getSqlData.insAktivitaet(Aktivitaet(bezeichnung = bezeichnung))
    }

    fun vorsatz(bezeichnung:String, intervall: Int, aktivitaet: Int, startdatum:String, zielmenge: Int, metrik: Int, aktiv:Boolean){
        SqlDatabase.getDatabase(context).getSqlData.insVorsatz(Vorsatz(bezeichnung = bezeichnung, intervall = intervall,
            aktivitaet = aktivitaet, startdatum = Converter().stringToDate(startdatum) ?: Date(), zielmenge = zielmenge, metrik = metrik, aktiv = aktiv))
    }

    fun intervall(bezeichnung:String, anzahl: Int){
        SqlDatabase.getDatabase(context).getSqlData.insIntervall(Intervall(bezeichnung = bezeichnung, anzahl = anzahl))
    }

    fun achievement(name:String, voraussetzung: String){
        SqlDatabase.getDatabase(context).getSqlData.insAchievemnt(Achievement(name =  name, datum = Converter().stringToDate("0000-01-01")!!, voraussetzung = voraussetzung))
    }
}