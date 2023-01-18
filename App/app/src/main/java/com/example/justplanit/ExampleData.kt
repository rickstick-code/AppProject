package com.example.justplanit

import android.content.Context

class ExampleData(var context: Context) {

    fun create() {
        if(SqlDatabase.getDatabase(context).getSqlData.selFortschritte().isNotEmpty()){return}

        metrik("Kilometer", "km")
        metrik("Liter", "l")
        metrik("Stunden", "h")

        fortschritt("2022-10-10", 0, 10, 0)
        fortschritt("2022-10-11", 0, 11, 1)
        fortschritt("2022-10-12", 0, 12, 2)
    }

    fun metrik(bezeichnung:String, einheit:String){
        SqlDatabase.getDatabase(context).getSqlData.insMetrik(Metrik(bezeichnung = bezeichnung, einheit = einheit))
    }

    fun fortschritt(datum:String, aktivitaet:Int, zielmenge:Int, metrik: Int){
        SqlDatabase.getDatabase(context).getSqlData.insFortschritt(Fortschritt(datum = Converter().stringToDate(datum), aktivitaet = aktivitaet, zielmenge = zielmenge, metrik = metrik))
    }
}