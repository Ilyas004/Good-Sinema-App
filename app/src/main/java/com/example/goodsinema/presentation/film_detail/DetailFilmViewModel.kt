package com.example.goodsinema.presentation.film_detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.usecase.delete_favorites_usecase.DeleteFavoritesUseCase
import com.example.goodsinema.domain.usecase.get_favorites_usecase.GetFavoritesUseCase
import com.example.goodsinema.domain.usecase.save_favorites_usecase.SaveFavoritesUseCase
import com.example.goodsinema.utills.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailFilmViewModel @Inject constructor(
    private val saveUseCase: SaveFavoritesUseCase,
    private val deleteUseCase: DeleteFavoritesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase

) : ViewModel() {
    var films : List<Film> by mutableStateOf(emptyList())


    fun checkFavorites(film: Film) : Boolean {
        for (item in films) {
            if (item.id == film.id) {
                return true
            }
        }
        return false
    }

    fun getFavoritesFilms() {
        viewModelScope.launch {
            films = getFavoritesUseCase()
        }
    }

    fun saveFilm(film: Film): Boolean {
        viewModelScope.launch {
            saveUseCase(film)
        }
        return true
    }

    fun deleteFilm(film: Film): Boolean {
        viewModelScope.launch {
            deleteUseCase(film)
        }
        return false
    }
}