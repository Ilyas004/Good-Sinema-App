package com.example.goodsinema.presentation.list_films

import com.example.goodsinema.data.model.FilmDto

data class ListFilmsState(
    val isLoading: Boolean = false,
    val films: List<FilmDto> = emptyList(),
    val error: String = ""
)
