package com.example.goodsinema.presentation.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.ui.theme.Blue
import com.example.goodsinema.presentation.ui.theme.Gray

@Composable
fun MainFilmsDisplay(
    films: List<Film>,
    onItemClickText: () -> Unit,
    onItemClickPoster: (Film) -> Unit,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Gray
        )
        Text(
            text = "Все",
            color = Blue,
            fontSize = 16.sp,
            modifier = Modifier.clickable { onItemClickText() }
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Card(backgroundColor = Color.Transparent) {
        LazyRow(content = {
            items(films) { film ->
                MainFilmPosterInfo(
                    film = film,
                    { onItemClickPoster(film) }
                )
            }
        })
    }
}