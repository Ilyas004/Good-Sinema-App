package com.example.goodsinema.di

import android.content.Context
import androidx.room.Room
import com.example.goodsinema.data.api.CinemaApi
import com.example.goodsinema.data.repository.FilmsDatabaseRepositoryImpl
import com.example.goodsinema.data.repository.FilmsRepositoryImpl
import com.example.goodsinema.data.storage.FilmsDao
import com.example.goodsinema.data.storage.FilmsDatabase
import com.example.goodsinema.domain.repository.FilmsDatabaseRepository
import com.example.goodsinema.domain.repository.FilmsRepository
import com.example.goodsinema.utills.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideCinemaApp(): CinemaApi {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CinemaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFilmsRepository(api: CinemaApi): FilmsRepository {
        return FilmsRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFilmsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            FilmsDatabase::class.java,
            "films_database"
        ).build()

    @Provides
    fun provideFilmsDao(appDatabase: FilmsDatabase): FilmsDao {
        return appDatabase.getFilmsDao()
    }

    @Provides
    @Singleton
    fun providesFilmsDatabaseRepository(dao: FilmsDao): FilmsDatabaseRepository {
        return FilmsDatabaseRepositoryImpl(dao)
    }


}