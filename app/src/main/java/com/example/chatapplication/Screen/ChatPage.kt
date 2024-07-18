package com.example.chatapplication.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chatapplication.Navigation.BottomNavigationBar

@Composable
fun ChatScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
            innerPadding ->
        Text(text = "This is Chat" , modifier = Modifier.padding(innerPadding))
    }
}