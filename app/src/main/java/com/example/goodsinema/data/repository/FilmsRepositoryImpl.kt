package com.example.goodsinema.data.repository

import com.example.goodsinema.data.api.CinemaApi
import com.example.goodsinema.data.model.FilmDto
import com.example.goodsinema.domain.repository.FilmsRepository
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val api: CinemaApi
) : FilmsRepository {

    override suspend fun getPopularFilms(): List<FilmDto> {
        val films = api.getPopularListFilms()
        return films.results
    }

    override suspend fun getNowPlayListFilms(): List<FilmDto> {
        val films = api.getNowPlayListFilms()
        return films.results
    }

    override suspend fun getTopRatedListFilms(): List<FilmDto> {
        val films = api.getTopPopularListFilms()
        return films.results
    }

}