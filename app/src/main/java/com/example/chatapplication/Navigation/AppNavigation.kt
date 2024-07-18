package com.example.chatapplication.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.chatapplication.Login.LoginPage
import com.example.chatapplication.Map.MapScreen
import com.example.chatapplication.Profile.ProfilePage
import com.example.chatapplication.Screen.ChatScreen
import com.example.chatapplication.SignUp.SignupScreen
import com.example.chatapplication.Profile.testingscrene
import com.example.chatapplication.SignUp.AboutMe
import com.example.chatapplication.SignUp.CreateUser
import com.example.chatapplication.UserInfo.DoYouDrink
import com.example.chatapplication.UserInfo.DoYouSmoke
import com.example.chatapplication.UserInfo.DoYouWantKids
import com.example.chatapplication.UserInfo.YourEducation
import com.example.chatapplication.UserInfo.YourReligion

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("signup") { SignupScreen(navController) }
        composable("profile") { ProfilePage(navController) }
        composable("map") { MapScreen(navController) }
        composable("chat") { ChatScreen(navController) }
        composable("Create_user") { CreateUser(navController)}
        composable("aboutme") { AboutMe(navController)}
        composable("DoYouDrink") { DoYouDrink(navController) }
        composable("DoYouSmoke") { DoYouSmoke(navController) }
        composable("YourReligion") { YourReligion(navController) }
        composable("YourEducation"){ YourEducation(navController)}
        composable("DoYouWantKids"){ DoYouWantKids(navController)}
        composable("user_profile/{userId}" ,
            arguments = listOf(navArgument("userId"){
            type = NavType.StringType

            }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments!!.getString("userId")
            if (userId != null) {
                testingscrene(navController = navController, userId = userId)
            }

        }

    }
}