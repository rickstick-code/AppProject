package com.example.justplanit

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date

@Entity
class Achievement(
    @PrimaryKey val name:String,
    @NotNull val erreicht: Boolean,
    @NotNull val datum: Date,

    ) {
}