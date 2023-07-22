package com.example.goodsinema.presentation.list_films

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.goodsinema.presentation.list_films.components.FilmsDisplay
import com.example.goodsinema.presentation.ui.theme.Blue

@Composable
fun ListFilmsScreen(
    viewModel: ListFilmsViewModel = hiltViewModel(),
    navController: NavController,
    event: String
) {
    viewModel.filmsEvent(event)
    val state = viewModel.stateFilms.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 10.dp, top = 8.dp, end = 5.dp)
    ) {
        FilmsDisplay(films = state.value.films, navController = navController)

        if (state.value.error.isNotBlank()) {
            Text(
                text = state.value.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)

            )
        }

        if (state.value.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Blue
            )
        }
    }
}