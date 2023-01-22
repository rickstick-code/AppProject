package com.example.justplanit

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.Date
import java.util.GregorianCalendar

@Entity
class Achievement(
    @PrimaryKey val name:String,
    @NotNull val datum: Date = Date(2000,1,1),
    val voraussetzung:String,
    val bild:ByteArray = Converter().bitmapToBytes(Bitmap.createBitmap(320,320,Bitmap.Config.ARGB_8888)),
    val kommentar:String = "space for comments"
    ) {
}