package com.example.goodsinema.presentation.list_films.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.ui.theme.Blue
import com.example.goodsinema.presentation.ui.theme.White

@Composable
fun FilmPosterInfo(
    film: Film,
    onItemClick: (Film) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(bottom = 15.dp)
            .clickable { onItemClick(film) }
    ) {
        Row {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/original${film.poster}",
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .padding(end = 10.dp),
            )
            Column {
                Text(
                    text = film.title,
                    color = White,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = film.originalTitle,
                    color = Blue,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Рейтинг: ${film.popularity}",
                    color = White,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = film.description,
                    color = White,
                    fontSize = 12.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp
                )
            }
        }
    }




}
