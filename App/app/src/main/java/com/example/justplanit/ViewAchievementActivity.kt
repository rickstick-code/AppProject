package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.justplanit.R

class ViewAchievementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_achievement)


        val achievementName = intent.getStringExtra("Achievement_id")

        if (achievementName == null) {
            //finish()
        }

        findViewById<TextView>(R.id.achievement_header).text = achievementName



        findViewById<Button>(R.id.achievement_save).setOnClickListener {
            finish()
        }
    }
}