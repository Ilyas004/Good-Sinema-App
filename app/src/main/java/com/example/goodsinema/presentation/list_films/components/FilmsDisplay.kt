package com.example.goodsinema.presentation.list_films.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.presentation.ui.theme.Blue

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
                    navController.navigate(Screen.DetailFilmInfo.route) {
                        popUpTo(Screen.ListFilms.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    })
    if (films.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Not favorite films",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 20.sp,
                color = Blue
            )
        }
    }

}