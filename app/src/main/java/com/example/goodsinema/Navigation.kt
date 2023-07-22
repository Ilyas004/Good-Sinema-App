package com.example.goodsinema

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.presentation.film_detail.DetailFilmInfoScreen
import com.example.goodsinema.presentation.list_films.ListFilmsScreen
import com.example.goodsinema.presentation.main.MainScreen

@Composable
fun Navigation(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(
            route = Screen.MainScreen.route
        ) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailFilmInfo.route
        ) {
            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Film>("film")
            if (result != null) {
                DetailFilmInfoScreen(film = result)
            }
        }
        composable(
            route = Screen.ListFilms.route + "/{event}",
            arguments = listOf(
                navArgument("event") {
                    type = NavType.StringType
                }
            )
        ) {
            val result = it.arguments?.getString("event") ?: ""
            ListFilmsScreen(navController = navController, event = result)
        }

        composable(
            route = Screen.FavoriteScreen.route + "/{event}",
            arguments = listOf(
                navArgument("event") {
                    type = NavType.StringType
                }
            )
        ) {
            val result = it.arguments?.getString("event") ?: ""
            ListFilmsScreen(navController = navController, event = result)
        }
    }
}