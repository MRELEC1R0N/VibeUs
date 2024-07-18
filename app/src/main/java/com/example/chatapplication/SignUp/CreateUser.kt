package com.example.chatapplication.SignUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController




@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CreateUser(
    navController: NavController
) {val hobbies = listOf(
    "#Music", "#Travel", "#Photography", "#Cooking", "#Sports",
    "#Reading", "#Gaming", "#Art", "#Dancing", "#Writing",
    "#Fashion", "#Movies", "#Technology", "#Gardening", "#Fitness",
    "#DIY", "#Pets","#Hiking", "#Yoga", "#Coding"
)
    var selectedHobbies by remember { mutableStateOf<List<String>>(emptyList()) }

    Scaffold(
        floatingActionButton = {
            BottomNavigationButton(navController = navController, route = "aboutme")
        }
    ){
        innerPadding ->

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)

    ) {
        item { // Item for "Interests" text
            Text(
                "Interests",
                fontSize = 48.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 32.dp)
            )
        }

        item { //Item for "0/5" text
            Text(
                "${selectedHobbies.size}/5",
                modifier = Modifier.padding(start = 32.dp, top = 8.dp),
                fontSize = 16.sp
            )
        }

        item { // Item for descriptive text
            Text(
                "Add 5 Interests to your profile. You’ll be able to discuss, engage, and meet like-minded souls in these communities",
                modifier = Modifier.padding(start = 32.dp, top = 8.dp, end = 32.dp),
                fontSize = 16.sp
            )
        }

        item { // Item for first divider
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }

        item { // Item for "Selected Hobbies" text
            Text("Selected Hobbies", modifier = Modifier.padding(start = 32.dp))
        }

        items(selectedHobbies) { hobby ->// Items for displaying selected hobbies
            Text(hobby, modifier = Modifier.padding(horizontal = 32.dp, vertical = 4.dp))
        }

        item { // Item for second divider
            Divider(
                color = Color.Gray,
                thickness = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = if (selectedHobbies.isEmpty()) 80.dp else 16.dp)
            )
        }

        items(hobbies.chunked(3)) { rowHobbies -> // Iterate over chunked hobbies
            FlowRow(
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowHobbies.forEach { hobby -> // Iterate over hobbies in each row
                    Button(
                        onClick = {
                            if (selectedHobbies.contains(hobby)) {
                                selectedHobbies = selectedHobbies - hobby
                            } else if (selectedHobbies.size < 5) {
                                selectedHobbies = selectedHobbies + hobby
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedHobbies.contains(hobby)) Color.LightGray else Color.White
                        )
                    ) {
                        Text(hobby)
                    }
                }
            }
        }
    }
    }
}



@Preview(showBackground = true , showSystemUi = true)
@Composable
fun CreateUserPreview() {
    CreateUser(rememberNavController())

}