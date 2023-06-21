package com.example.goodsinema.data.api

import com.example.goodsinema.data.model.FilmsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CinemaApi {

    @GET("movie/popular")
    suspend fun getListFilms(
        @Query("api_key") key: String
    ): FilmsDto

}