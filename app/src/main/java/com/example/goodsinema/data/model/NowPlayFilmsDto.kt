package com.example.goodsinema.data.model

data class NowPlayFilmsDto(
    val dates: Dates,
    val page: Int,
    val results: List<FilmDto>,
    val total_pages: Int,
    val total_results: Int,
)