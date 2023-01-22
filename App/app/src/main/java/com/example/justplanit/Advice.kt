package com.example.justplanit

data class Advice(
    val slip: Slip
)

data class Slip(
    val id: Int,
    val advice: String
)