package com.example.goodsinema.presentation.list_films

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.usecase.get_favorites_usecase.GetFavoritesUseCase
import com.example.goodsinema.presentation.main.ListFilmsState
import com.example.goodsinema.utills.Broker
import com.example.goodsinema.utills.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListFilmsViewModel @Inject constructor(
    private val favoriteUseCase: GetFavoritesUseCase,
) : ViewModel() {
    private val _stateFilms = MutableStateFlow(ListFilmsState())
    val stateFilms : StateFlow<ListFilmsState> = _stateFilms.asStateFlow()

    fun filmsEvent(event: String) {
        when(event) {
            Constant.GET_FAVORITES_FILMS -> {
                getFavoritesFilms()
            }
            Constant.GET_BROKER_FILMS -> {
                getArguments()
            }
        }

    }

    private fun getFavoritesFilms() {
        viewModelScope.launch {
           _stateFilms.value.films = favoriteUseCase()
        }

    }

    private fun getArguments() {
        val data = Broker.BROKER_FILMS
        _stateFilms.value.films = data ?: emptyList<Film>()
    }

}