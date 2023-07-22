package com.example.goodsinema.presentation.bottom_bar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.goodsinema.presentation.ui.theme.Black
import com.example.goodsinema.presentation.ui.theme.Blue
import com.example.goodsinema.presentation.ui.theme.White

@Composable
fun BottomBar(navController: NavController) {
    val listItems = listOf(
        BottomItem.HomeScreen,
        BottomItem.FavoriteScreen
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomNavigation(
            backgroundColor = White,
            modifier = Modifier
                .border(0.5.dp, color = Black),
            elevation = 8.dp,


        ) {
            listItems.forEach { screen ->
                BottomNavigationItem(
                    selected = currentRoute?.substringBefore("/") == screen.route.substringBefore("/"),
                    onClick = { navController.navigate(screen.route) },
                    icon = {
                        Icon(painter = painterResource(id = screen.icon), contentDescription = "")
                    },
                    selectedContentColor = Blue,
                    unselectedContentColor = Black,

                    )
            }
        }
    }
}