package com.example.goodsinema.domain.usecase.save_favorites_usecase

import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.repository.FilmsDatabaseRepository
import javax.inject.Inject

class SaveFavoritesUseCase @Inject constructor(
    private val repository: FilmsDatabaseRepository
) {
    suspend operator fun invoke(film: Film) {
        repository.saveData(film)
    }

}