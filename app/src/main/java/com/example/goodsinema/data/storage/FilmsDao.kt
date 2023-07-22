package com.example.goodsinema.data.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.goodsinema.data.model.FilmDB

@Dao
interface FilmsDao {

    @Query("SELECT * FROM films")
    suspend fun getFilms(): List<FilmDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setFilm(filmDB: FilmDB)

    @Delete
    suspend fun deleteFilm(filmDB: FilmDB)
}