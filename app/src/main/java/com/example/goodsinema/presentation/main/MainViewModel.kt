package com.example.goodsinema.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.usecase.get_films_usecase.GetNowPlayUseCase
import com.example.goodsinema.domain.usecase.get_films_usecase.GetPopularFilmsUseCase
import com.example.goodsinema.domain.usecase.get_films_usecase.GetTopRatedFilmsUseCase
import com.example.goodsinema.utills.Broker
import com.example.goodsinema.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPopularFilmsUseCase: GetPopularFilmsUseCase,
    private val getTopRatedFilmsUseCase: GetTopRatedFilmsUseCase,
    private val getNowPlayUseCase: GetNowPlayUseCase,
): ViewModel() {

    private val _stateTopFilm = MutableStateFlow(ListFilmsState())
    val stateTopFilm: StateFlow<ListFilmsState> = _stateTopFilm.asStateFlow()

    private val _statePopularFilm = MutableStateFlow(ListFilmsState())
    val statePopularFilm: StateFlow<ListFilmsState> = _statePopularFilm.asStateFlow()

    private val _stateNowPlayFilm = MutableStateFlow(ListFilmsState())
    val stateNowPlayFilm: StateFlow<ListFilmsState> = _stateNowPlayFilm.asStateFlow()

    init {
        getPopularFilms()
        getTopRatedFilms()
        getNowPlayFilms()
    }

    private fun getPopularFilms() {
        viewModelScope.launch {
            getPopularFilmsUseCase().collect { result ->
                updateFilmsState(result, _statePopularFilm)
            }
        }
    }

    private fun getTopRatedFilms() {
        viewModelScope.launch {
            getTopRatedFilmsUseCase().collect { result ->
                updateFilmsState(result, _stateTopFilm)
            }
        }
    }

    private fun getNowPlayFilms() {
        viewModelScope.launch {
            getNowPlayUseCase().collect { result ->
                updateFilmsState(result, _stateNowPlayFilm)
            }
        }
    }

    private fun updateFilmsState(
        result: Resource<List<Film>>,
        stateFlow: MutableStateFlow<ListFilmsState>
    ) {
        when (result) {
            is Resource.Success -> {
                stateFlow.value = ListFilmsState(films = result.data ?: emptyList())
            }
            is Resource.Error -> {
                stateFlow.value = ListFilmsState(error = result.message ?: "An unexpected error occurred")
            }
            is Resource.Loading -> {
                stateFlow.value = ListFilmsState(isLoading = true)
            }
        }
    }

    fun postBrokerFilms(films: List<Film>) {
        viewModelScope.launch {
            Broker.BROKER_FILMS = films
        }
    }

}