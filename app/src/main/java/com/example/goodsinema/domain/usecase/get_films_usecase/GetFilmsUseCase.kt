package com.example.goodsinema.domain.usecase.get_films_usecase

import com.example.goodsinema.data.model.FilmsDto
import com.example.goodsinema.data.model.toFilm
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.domain.repository.FilmsRepository
import com.example.goodsinema.utills.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private val repository: FilmsRepository
) {
    suspend fun execute(): Flow<Resource<List<Film>>> = flow {
        try {
            emit(Resource.Loading())
            val films = repository.getFilms().component2().map { it.toFilm() }
            emit(Resource.Success(films))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}