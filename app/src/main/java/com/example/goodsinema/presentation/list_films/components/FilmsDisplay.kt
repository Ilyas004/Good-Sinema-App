package com.example.goodsinema.presentation.list_films.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.Screen

@Composable
fun FilmsDisplay(
    films: List<Film>,
    navController: NavController
) {

    LazyColumn(content = {
        items(films) { item ->
            FilmPosterInfo(
                film = item,
                onItemClick = { film ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "film",
                        value = film
                    )
                    navController.navigate(Screen.DetailFilmInfo.route)
                }
            )
        }
    })

}