package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.justplanit.R
import com.example.justplanit.ui.home.HomeFragment

class ViewResolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_resolution)

        val resolutionName = intent.getIntExtra(HomeFragment.RESOLUTION_ID,0)

        /*if (resolutionName == null) {
            finish()
        }
*/
        findViewById<TextView>(R.id.respro_header).text = resolutionName.toString()

    }
}