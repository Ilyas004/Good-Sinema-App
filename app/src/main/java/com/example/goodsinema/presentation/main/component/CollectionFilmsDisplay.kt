package com.example.goodsinema.presentation.main.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.presentation.main.MainViewModel
import com.example.goodsinema.presentation.ui.theme.DarkGray
import com.example.goodsinema.presentation.ui.theme.Gray
import com.example.goodsinema.utills.Broker
import com.example.goodsinema.utills.Constant
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun CollectionFilmsDisplay(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController,
) {
    val stateNowPlayFilms = viewModel.stateNowPlayFilm.collectAsState()
    val statePopularFilms = viewModel.statePopularFilm.collectAsState()
    val stateTopFilms = viewModel.stateTopFilm.collectAsState()

    LazyColumn(content = {
        item {
            Text(
                text = "Что посмотрим?",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                color = Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Ваш следующий фильм для просмотра",
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                color = DarkGray
            )
            Spacer(modifier = Modifier.height(25.dp))
        }

        stateNowPlayFilms.value.films.let { films ->
            item {
                MainFilmsDisplay(
                    films = films,
                    text = "Недавно вышедшие",
                    onItemClickText = {
                        viewModel.postBrokerFilms(films)
                        navController.navigate(
                            Screen.ListFilms.route + "/${Constant.GET_BROKER_FILMS}"
                        )
                    },
                    onItemClickPoster = { film ->
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "film",
                            value = film
                        )
                        navController.navigate(Screen.DetailFilmInfo.route)
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        stateTopFilms.value.films.let { films ->
            item {
                MainFilmsDisplay(
                    films = films,
                    text = "Фильм с высоким рейтингом",
                    onItemClickText = {
                        viewModel.postBrokerFilms(films)
                        navController.navigate(
                            Screen.ListFilms.route + "/${Constant.GET_BROKER_FILMS}"
                        )
                    },
                    onItemClickPoster = { film ->
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "film",
                            value = film
                        )
                        navController.navigate(Screen.DetailFilmInfo.route)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }

        statePopularFilms.value.films.let { films ->
            item {
                MainFilmsDisplay(
                    films = films,
                    text = "Популярные",
                    onItemClickText = {
                        viewModel.postBrokerFilms(films)
                        navController.navigate(
                            Screen.ListFilms.route + "/${Constant.GET_BROKER_FILMS}"
                        )
                    },
                    onItemClickPoster = { film ->
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "film",
                            value = film
                        )
                        navController.navigate(Screen.DetailFilmInfo.route)
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }

    })

}