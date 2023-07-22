package com.example.goodsinema.presentation.main

import com.example.goodsinema.domain.model.Film

data class ListFilmsState(
    val isLoading: Boolean = false,
    var films: List<Film> = emptyList(),
    val error: String = ""
)
