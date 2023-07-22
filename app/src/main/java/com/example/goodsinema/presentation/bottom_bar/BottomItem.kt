package com.example.goodsinema.presentation.bottom_bar

import com.example.goodsinema.R
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.utills.Constant

sealed class BottomItem(val route: String, val icon: Int) {
    object HomeScreen: BottomItem(
        route = Screen.MainScreen.route,
        icon = R.drawable.home2
    )
    object FavoriteScreen: BottomItem(
        route = Screen.FavoriteScreen.route + "/${Constant.GET_FAVORITES_FILMS}",
        icon = R.drawable.favorite

    )
}