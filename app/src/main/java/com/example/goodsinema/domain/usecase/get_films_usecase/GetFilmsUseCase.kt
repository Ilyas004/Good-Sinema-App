package com.example.goodsinema.domain.usecase.get_films_usecase

import com.example.goodsinema.data.model.FilmsDto
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.repository.FilmsRepository
import com.example.goodsinema.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private val repository: FilmsRepository
) {
    suspend fun execute(): Flow<Resource<FilmsDto>> = flow {
        try {
            emit(Resource.Loading<List<Film>>())
            val films = repository.getFilms().map
        }
    }
}