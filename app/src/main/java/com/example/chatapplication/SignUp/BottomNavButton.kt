package com.example.chatapplication.SignUp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomNavigationButton(navController: NavController , route: String) {
    FloatingActionButton(onClick = {navController.navigate(route)},
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Gray) {
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = null
        )

    }

}