package com.example.goodsinema.presentation

sealed class Screen(val route: String) {
    object ListFilms: Screen("list_films_screen")
    object DetailFilmInfo: Screen("detail_film_info_screen")
    object MainScreen: Screen("main_screen")
    object FavoriteScreen: Screen("favorite_films_screen")
}
