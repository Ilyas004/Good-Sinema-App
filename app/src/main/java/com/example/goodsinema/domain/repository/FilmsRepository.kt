package com.example.goodsinema.domain.repository

import com.example.goodsinema.data.model.FilmsDto
import com.example.goodsinema.utills.Resource

interface FilmsRepository {

    suspend fun getFilms(): FilmsDto

}