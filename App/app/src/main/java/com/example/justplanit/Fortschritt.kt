package com.example.justplanit

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity
class Fortschritt (
    @PrimaryKey val id: Int,
    @NotNull val datum: Date = Date(), //check if this actually giving out the current date
    @NotNull val aktivitaet: Int,
    @NotNull val metrik: Int,
    @NotNull val zielmenge: Int ){
}