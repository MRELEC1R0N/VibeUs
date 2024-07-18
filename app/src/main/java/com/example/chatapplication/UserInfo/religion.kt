package com.example.chatapplication.UserInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.R
import com.example.chatapplication.SignUp.BottomNavigationButton

@Composable
fun YourReligion(
    navController: NavController
) {

    var selectedOption by remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            BottomNavigationButton(navController = navController, route = "YourEducation")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFF111318)),
            horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
            verticalArrangement = Arrangement.Center // Center content vertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.sikh),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                "Your Religion",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = {
                    selectedOption = "Hindu"
                    navController.navigate("YourEducation") // Navigate to login on click
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF292E38),
                    contentColor = Color.White

                )

            ) {
                Text("Hindu")
            }

            Button(
                onClick = {
                    selectedOption = "Sikh"
                    navController.navigate("YourEducation") // Navigate to login on click
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF292E38),
                    contentColor = Color.White
                )
            ) {
                Text("Sikh")
            }

            Button(
                onClick = {
                    selectedOption = "Muslim"
                    navController.navigate("YourEducation") // Navigate to login on click
                },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 8.dp),


                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF292E38),
                    contentColor = Color.White)
            ) {
                Text("Muslim")
            }
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewDoYouReligion() {
    YourReligion(navController = rememberNavController())

}