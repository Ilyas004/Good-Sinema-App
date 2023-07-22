package com.example.goodsinema.presentation.film_detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.goodsinema.R
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.film_detail.component.DetailInfoFilmView

@Composable
fun DetailFilmInfoScreen(
    viewModel: DetailFilmViewModel = hiltViewModel(),
    film: Film
) {
    viewModel.getFavoritesFilms()
    var isFavorites: Boolean by remember { mutableStateOf(true) }
    isFavorites = viewModel.checkFavorites(film)


    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original${film.background}",
                contentDescription = null,
            )
            DetailInfoFilmView(film = film)
        }
        Image(
            painter = painterResource(
                if (isFavorites) {
                    R.drawable.is_favorite
                } else {
                    R.drawable.is_not_favorite
                }
            ),
            contentDescription = "Добавить в избранное",
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .clickable {
                    isFavorites = if (isFavorites) {
                        viewModel.deleteFilm(film)
                    } else {
                        viewModel.saveFilm(film)

                    }
                },
        )

    }
}