package com.example.goodsinema.data.repository

import com.example.goodsinema.data.api.CinemaApi
import com.example.goodsinema.data.model.FilmsDto
import com.example.goodsinema.domain.repository.FilmsRepository
import com.example.goodsinema.utills.Constant
import com.example.goodsinema.utills.Resource
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val api: CinemaApi
) : FilmsRepository {

    override suspend fun getFilms(): Resource<FilmsDto> {
        return try {
            Resource.Success(
                data = api.getListFilms(Constant.KEY_API)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(
                message = e.message ?: "An unknown error occurred."
            )
        }

    }
}