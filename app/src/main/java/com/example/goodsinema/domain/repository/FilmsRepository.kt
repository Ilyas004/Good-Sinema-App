package com.example.goodsinema.domain.repository

import com.example.goodsinema.data.model.FilmDto

interface FilmsRepository {

    suspend fun getPopularFilms(): List<FilmDto>

    suspend fun getNowPlayListFilms(): List<FilmDto>

    suspend fun getTopRatedListFilms(): List<FilmDto>

}