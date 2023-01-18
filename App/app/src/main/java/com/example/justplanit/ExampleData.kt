package com.example.justplanit

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import java.util.*

class ExampleData(var context: Context) {

    fun create() {
        metrik("Kilometer", "km")
        metrik("Liter", "l")
        metrik("Stunden", "h")

        fortschritt("2022-10-10", 0, 10, 0)
        fortschritt("2022-10-10", 0, 10, 1)
        fortschritt("2022-10-10", 0, 10, 2)
    }

    fun metrik(bezeichnung:String, einheit:String){
        SqlDatabase.getDatabase(context).getSqlData.insMetrik(Metrik(bezeichnung = "Kilometer", einheit = "km"))
    }

    fun fortschritt(datum:String, aktivitaet:Int, zielmenge:Int, metrik: Int){
        SqlDatabase.getDatabase(context).getSqlData.insFortschritt(Fortschritt(datum = Date(datum), aktivitaet = aktivitaet, zielmenge = zielmenge, metrik = metrik))
    }
}