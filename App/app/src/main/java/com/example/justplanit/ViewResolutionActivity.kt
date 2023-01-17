package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.justplanit.R

class ViewResolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_resolution)

        val resolutionName = intent.getStringExtra("Resolution_id")

        if (resolutionName == null) {
            finish()
        }

        findViewById<TextView>(R.id.respro_header).text = resolutionName

    }
}