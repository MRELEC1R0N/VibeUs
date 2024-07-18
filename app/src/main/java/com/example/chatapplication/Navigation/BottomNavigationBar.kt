package com.example.chatapplication.Navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation (
        backgroundColor = Color(0xFF292E38)
    ){
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            selected = false, // You'll need to manage the selected state
            onClick = { navController.navigate("profile") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Map, contentDescription = "Map") },
            selected =false,
            onClick = { navController.navigate("map") }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Chat, contentDescription = "Chat") },
            selected = false,
            onClick = { navController.navigate("chat") }
        )
    }
}