package com.example.justplanit

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(indices = [Index(value = ["bezeichnung"], unique = true)])
class Aktivitaet (
    @PrimaryKey val id:Int,
    @NotNull val bezeichnung:String ){
}