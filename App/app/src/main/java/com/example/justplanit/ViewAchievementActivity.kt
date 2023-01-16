package com.example.justplanit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.justplanit.R

class ViewAchievementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_achievement)

        findViewById<Button>(R.id.achievement_save).setOnClickListener {
            finish()
        }
    }
}