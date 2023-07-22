package com.example.goodsinema.utills

import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.main.ListFilmsState
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

@Singleton
object Broker{
    var BROKER_FILMS: List<Film>? = null
}