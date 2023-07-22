package com.example.goodsinema.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.goodsinema.domain.model.Film

@Entity(tableName = "films")
data class FilmDB (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val originalTitle: String,
    val poster: String,
    val background: String,
    val dataRelease: String,
    val popularity: Double,
    val description: String
)

fun FilmDB.toFilm(): Film {
    return Film(
        id = id,
        title = title,
        originalTitle = originalTitle,
        poster = poster,
        background = background,
        dataRelease = dataRelease,
        popularity = popularity,
        description = description
    )
}