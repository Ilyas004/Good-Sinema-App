package com.example.goodsinema.domain.usecase.get_favorites_usecase

import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.repository.FilmsDatabaseRepository
import com.example.goodsinema.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val repository: FilmsDatabaseRepository
) {
    suspend operator fun invoke(): List<Film> {
        return repository.getData()
    }
}