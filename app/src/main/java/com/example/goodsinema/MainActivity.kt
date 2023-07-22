package com.example.goodsinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.goodsinema.domain.model.Film
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.presentation.bottom_bar.BottomBar
import com.example.goodsinema.presentation.film_detail.DetailFilmInfoScreen
import com.example.goodsinema.presentation.list_films.ListFilmsScreen
import com.example.goodsinema.presentation.main.ListFilmsState
import com.example.goodsinema.presentation.main.MainScreen
import com.example.goodsinema.presentation.ui.theme.Black
import com.example.goodsinema.presentation.ui.theme.DarkBlue
import com.example.goodsinema.presentation.ui.theme.GoodSinemaTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            GoodSinemaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Black, DarkBlue),
                            )
                        )
                    ) {
                        Navigation(navController = navController)
                        BottomBar(navController = navController)
                    }
                }
            }
        }
    }
}
