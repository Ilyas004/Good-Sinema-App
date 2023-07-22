package com.example.goodsinema.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.goodsinema.data.model.FilmDB

@Database(entities = [FilmDB::class], version = 1, exportSchema = true)
abstract class FilmsDatabase: RoomDatabase() {
    abstract fun getFilmsDao(): FilmsDao

}