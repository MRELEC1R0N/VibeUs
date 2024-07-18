package com.example.chatapplication.SignUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutMe(
    navCOntroller: NavController
) {
    var UserAboutme by remember {
        mutableStateOf("")
    }
    Scaffold(
        floatingActionButton = {
            BottomNavigationButton(navController = navCOntroller, route = "DoYouDrink")
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
                Text("About Me",
                    modifier = Modifier.padding(start = 16.dp , top = 72.dp),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.SemiBold)

            Box(modifier = Modifier
                .padding(top = 32.dp, start = 16.dp, end = 16.dp)
                .background(
                    Color(0xFF292E38),
                    shape = RoundedCornerShape(16.dp)
                )){
                OutlinedTextField(value = UserAboutme, onValueChange = {UserAboutme = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(
                            minHeight = 200.dp
                        ),
                    shape = RoundedCornerShape(16.dp))
            }

        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewAboutMe(){
    AboutMe(rememberNavController())

}