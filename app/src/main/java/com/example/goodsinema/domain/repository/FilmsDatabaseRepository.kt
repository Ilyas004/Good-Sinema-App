package com.example.goodsinema.domain.repository

import com.example.goodsinema.domain.model.Film

interface FilmsDatabaseRepository {

    suspend fun saveData(film: Film)

    suspend fun getData() : List<Film>

    suspend fun deleteData(film: Film)
}