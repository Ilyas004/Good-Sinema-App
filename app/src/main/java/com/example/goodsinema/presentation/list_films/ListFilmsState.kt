package com.example.goodsinema.presentation.list_films

import com.example.goodsinema.domain.model.Film

data class ListFilmsState(
    val isLoading: Boolean = false,
    val films: List<Film> = emptyList(),
    val error: String = ""
)
