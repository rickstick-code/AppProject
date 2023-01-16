package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.justplanit.R

class CreateResolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_resolution)

        findViewById<Button>(R.id.resolution_save).setOnClickListener{
            finish()
        }
    }
}