package com.example.goodsinema.presentation.main.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.goodsinema.R
import com.example.goodsinema.presentation.Screen
import com.example.goodsinema.presentation.main.MainViewModel
import com.example.goodsinema.presentation.ui.theme.Black
import com.example.goodsinema.presentation.ui.theme.Blue
import com.example.goodsinema.presentation.ui.theme.White
import com.example.goodsinema.utills.Constant

@Composable
fun FindFilmsView(
    navController: NavController
) {
    val state = remember { mutableStateOf("") }

    Card(
        backgroundColor = White,
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, Blue),
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            TextField(
                value = state.value,
                maxLines = 1,
                onValueChange = { state.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Black,
                    cursorColor = Black,
                ),
                textStyle = TextStyle.Default.copy(fontSize = 18.sp)
            )
            Image(
                painter = painterResource(id = R.drawable.search2),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
                    .clickable {
                        navController.navigate(Screen.ListFilms.route + "/${state.value}")
                        Log.d("TAG", "state = ${state.value}")
                    }
            )
        }
    }
}