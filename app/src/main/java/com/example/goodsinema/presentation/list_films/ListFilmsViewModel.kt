package com.example.goodsinema.presentation.list_films

import com.example.goodsinema.domain.usecase.get_films_usecase.GetFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ListFilmsViewModel @Inject constructor(
    private val useCase: GetFilmsUseCase
) {

    private val _state = MutableStateFlow(ListFilmsState())
    val state: StateFlow<ListFilmsState> = _state

    init {

    }

    fun getFilms() {

        useCase.execute().onEach( result ->
        )
    }
}