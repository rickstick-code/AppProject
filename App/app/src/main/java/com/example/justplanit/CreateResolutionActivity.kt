package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.justplanit.R
import java.util.*

class CreateResolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_resolution)

        findViewById<Button>(R.id.resolution_save).setOnClickListener {
            Toast.makeText(applicationContext,"A new resolution was created", Toast.LENGTH_SHORT).show()
            SqlDatabase.getDatabase(applicationContext).getSqlData.insVorsatz(
                Vorsatz(
                    bezeichnung = findViewById<TextView>(R.id.resolution_name).text.toString(),
                    intervall = SqlDatabase.getDatabase(applicationContext).
                        getSqlData.selIntervall(findViewById<Spinner>(R.id.resolution_frequency).selectedItem.toString()),
                    aktivitaet = SqlDatabase.getDatabase(applicationContext).
                        getSqlData.selAktivitaet(findViewById<Spinner>(R.id.resolution_activty).selectedItem.toString()),
                    startdatum = Date(), //TODO - Datum muss noch vom text genommen werden und dann mit converter klasse umgewandelt werden
                    zielmenge = findViewById<TextView>(R.id.resolution_goal).text.toString().toIntOrNull() ?: 0,
                    metrik = SqlDatabase.getDatabase(applicationContext).
                        getSqlData.selMetrik(findViewById<Spinner>(R.id.resolution_unit).selectedItem.toString()),
                    aktiv = true
                )
            )
            finish()
        }

        //Um den Aktvität-Spinner aufzufüllen
        findViewById<Spinner>(R.id.resolution_activty).adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            SqlDatabase.getDatabase(applicationContext).getSqlData.selAktivitaet().map { it.bezeichnung })


        //Um den Metrik-Spinner aufzufüllen
        findViewById<Spinner>(R.id.resolution_unit).adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            SqlDatabase.getDatabase(applicationContext).getSqlData.selMetrik().map { it.einheit })

        //Um den Metrik-Spinner aufzufüllen
        findViewById<Spinner>(R.id.resolution_frequency).adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            SqlDatabase.getDatabase(applicationContext).getSqlData.selIntervall().map { it.anzahl.toString() + " " + it.bezeichnung })
    }
}