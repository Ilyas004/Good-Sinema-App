package com.example.goodsinema.presentation.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.utills.Broker

@Composable
fun MainFilmPosterInfo(
    film: Film,
    onItemClick: () -> Unit
) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/original${film.poster}",
        contentDescription = null,
        modifier = Modifier
            .width(160.dp)
            .clickable { onItemClick()}
            .padding(end = 10.dp),
    )
}