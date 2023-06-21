package com.example.goodsinema.di

import com.example.goodsinema.data.api.CinemaApi
import com.example.goodsinema.data.repository.FilmsRepositoryImpl
import com.example.goodsinema.domain.repository.FilmsRepository
import com.example.goodsinema.domain.usecase.get_films_usecase.GetFilmsUseCase
import com.example.goodsinema.utills.CinemaApp
import com.example.goodsinema.utills.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCinemaApp(): CinemaApp {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    fun provideFilmsRepository(api: CinemaApi): FilmsRepository {
        return FilmsRepositoryImpl(api)
    }

    @Provides
    fun provideGetFilmsUseCase(repository: FilmsRepository): GetFilmsUseCase {
        return GetFilmsUseCase(repository)
    }


}