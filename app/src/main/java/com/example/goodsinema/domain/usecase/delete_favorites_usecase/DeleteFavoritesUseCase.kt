package com.example.goodsinema.domain.usecase.delete_favorites_usecase

import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.repository.FilmsDatabaseRepository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(
    private val repository: FilmsDatabaseRepository
) {
    suspend operator fun invoke(film: Film) {
        repository.deleteData(film)
    }
}