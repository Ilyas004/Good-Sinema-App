package com.example.goodsinema.presentation.list_films

import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.goodsinema.domain.usecase.get_films_usecase.GetFilmsUseCase
import com.example.goodsinema.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
        useCase.execute().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ListFilmsState(films = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ListFilmsState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = ListFilmsState(isLoading = true)
                }
            }
        }.launchIn()
    }
}