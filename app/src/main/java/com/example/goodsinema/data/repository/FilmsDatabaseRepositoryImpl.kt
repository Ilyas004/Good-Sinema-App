package com.example.goodsinema.data.repository

import com.example.goodsinema.data.model.toFilm
import com.example.goodsinema.data.storage.FilmsDao
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.model.toFilmDB
import com.example.goodsinema.domain.repository.FilmsDatabaseRepository
import javax.inject.Inject

class FilmsDatabaseRepositoryImpl @Inject constructor(
    private val dao: FilmsDao
) : FilmsDatabaseRepository {

    override suspend fun saveData(film: Film) {
        dao.setFilm(film.toFilmDB())
    }

    override suspend fun getData() : List<Film> {
        val films = dao.getFilms()
        return films.map { it.toFilm() }
    }

    override suspend fun deleteData(film: Film) {
        dao.deleteFilm(film.toFilmDB())
    }
}