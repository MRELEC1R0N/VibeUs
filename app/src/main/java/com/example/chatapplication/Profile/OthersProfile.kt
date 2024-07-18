package com.example.chatapplication.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.Map.UserProfile
import com.example.chatapplication.R
import com.example.chatapplication.SampleData.getUserProfile


@Composable
fun testingscrene(
    navController: NavController, userId: String
){
    Text(text = "WElcome to $userId profile")

    UserProfileScreen(navController = navController, userProfile = getUserProfile(userId))
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserProfileScreen( navController: NavController , userProfile: UserProfile ){
    val scrollState = rememberScrollState()


    if (userProfile != null) {
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState) // Add vertical scroll
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Image(
                        painter = painterResource(id = userProfile.imageUrl), // Replace with your actual image
                        contentDescription = "Profile Image", // Add a meaningful description
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(
                                    bottomEnd = 32.dp,
                                    bottomStart = 32.dp
                                )
                            )
                    )

                    Text(
                        text = "${userProfile.name}, ${userProfile.age}",
                        modifier = Modifier.padding(bottom = 32.dp, start = 16.dp),
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))



                Spacer(modifier = Modifier.height(32.dp))

                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )

                // Languages Section
                Text(
                    text = "Languages I Know",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp) // Consistent padding
                )

                Spacer(modifier = Modifier.height(16.dp))

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp) // Consistent padding
                ) {
                   TagRow_other(tags = userProfile.languages)

                }

                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Other Interests Section (Consider using a LazyRow here for better performance)
                FlowRow(modifier = Modifier.padding(8.dp)) {
                    userProfile.interests.forEach{ intrest ->
                        TagCard_other(text = intrest)
                    }

                                }

                Spacer(modifier = Modifier.height(16.dp))
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF292E38)
                        )
                    ) {
                        Text(
                            text = userProfile.aboutMe,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )


            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 16.dp),

                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { navController.navigate("map") } , modifier =  Modifier.padding(top = 32.dp , bottom = 8.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.cancel),
                            contentDescription = null,
                            modifier = Modifier.size(68.dp)
                        )

                    }

                    IconButton(onClick = { navController.navigate("chat") } ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(68.dp)

                        )
                    }
                    IconButton(onClick = { navController.navigate("chat") } , modifier =  Modifier.padding(top = 32.dp , bottom = 8.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.check_mark),
                            contentDescription = null,
                            modifier = Modifier.size(68.dp)
                        )
                    }
                }
            }
            }
        } else{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState) // Add vertical scroll
            ) {
                Text(text = "User Profile Not Found " , color = Color.Red)
            }
    }

    }






@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagRow_other(
    tags: List<String>
){
    FlowRow {
        tags.forEach{tag ->
            TagCard_other(text = tag)
        }
    }
}

@Composable
fun TagCard_other(text: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp) // Reduced padding for better spacing
            .width(100.dp)
            .height(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292E38)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box( // Using Box for simpler centering
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true )
@Composable
fun OtherProfilePrevew() {
    testingscrene(navController = rememberNavController(), userId = "user2")
}