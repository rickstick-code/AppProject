package com.example.justplanit

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
class Fortschritt(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @NotNull val datum: Date = Date(),
    @NotNull val aktivitaet: Int = 0,
    @NotNull val metrik: Int = 0,
    @NotNull val zielmenge: Int = 0 ){
}