package com.example.goodsinema.domain.model

import android.os.Parcelable
import com.example.goodsinema.data.model.FilmDB
import kotlinx.parcelize.Parcelize


@Parcelize
data class Film (
    val id: Int = 0,
    val title: String = "",
    val originalTitle: String = "",
    val poster: String = "",
    val background: String = "",
    val dataRelease: String = "",
    val popularity: Double = 0.0,
    val description: String = ""
): Parcelable

fun Film.toFilmDB(): FilmDB {
    return FilmDB(
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
