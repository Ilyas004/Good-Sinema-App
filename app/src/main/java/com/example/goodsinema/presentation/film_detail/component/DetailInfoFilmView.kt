package com.example.goodsinema.presentation.film_detail.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.ui.theme.Black
import com.example.goodsinema.presentation.ui.theme.Blue
import com.example.goodsinema.presentation.ui.theme.White
import com.example.goodsinema.R

@Composable
fun DetailInfoFilmView(
    film: Film
) {
    val date = film.dataRelease.substringBefore("-")

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        Text(
            text = "${film.title} ($date)",
            fontSize = 18.sp,
            color = White
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = film.originalTitle,
            fontSize = 14.sp,
            color = Blue
        )
        Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Рейтинг: ${film.popularity}",
                fontSize = 14.sp,
                color = White
            )


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Содержание:",
            fontSize = 14.sp,
            color = White
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = film.description,
            color = White,
            fontSize = 14.sp,
            lineHeight = 18.sp
        )
    }
}