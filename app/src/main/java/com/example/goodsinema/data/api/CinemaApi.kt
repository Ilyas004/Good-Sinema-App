package com.example.goodsinema.data.api

import com.example.goodsinema.data.model.FilmsDto
import com.example.goodsinema.utills.Constant
import org.intellij.lang.annotations.Language
import retrofit2.http.GET
import retrofit2.http.Query

interface CinemaApi {

    @GET("3/movie/popular")
    suspend fun getPopularListFilms(
        @Query("language") language: String = "ru",
        @Query("api_key") key: String = Constant.KEY_API
    ): FilmsDto

    @GET("3/movie/top_rated")
    suspend fun getTopPopularListFilms(
        @Query("language") language: String = "ru",
        @Query("api_key") key: String = Constant.KEY_API
    ): FilmsDto

    @GET("3/movie/now_playing")
    suspend fun getNowPlayListFilms(
        @Query("language") language: String = "ru",
        @Query("api_key") key: String = Constant.KEY_API
    ): FilmsDto

}