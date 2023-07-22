package com.example.goodsinema.data.model

import com.example.goodsinema.domain.model.Film

data class FilmDto(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun FilmDto.toFilm(): Film {
    return Film(
        id = id,
        title = title,
        originalTitle = original_title,
        poster = poster_path,
        background = backdrop_path,
        dataRelease = release_date,
        popularity = vote_average,
        description = overview
    )
}
