package com.example.goodsinema.domain.model

data class Film (
    val id: Int,
    val title: String,
    val poster: String,
    val dataRelease: String,
    val popularity: Double,
    val description: String
)