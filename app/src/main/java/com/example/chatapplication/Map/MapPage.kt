package com.example.chatapplication.Map

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chatapplication.Navigation.BottomNavigationBar
import com.example.chatapplication.R
import com.example.chatapplication.SampleData.getlist


@Composable
fun MapScreen(
    navController: NavController
) {
    var showDailog by remember {
        mutableStateOf(false)
    }


    val userProfiles = getlist()



    Scaffold (
        floatingActionButton = {
            ViewUserButton(
                showDialog = showDailog,
                onShowDialogChange = {
                    showDailog = it
                }
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ){
        innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Image(
                painter = painterResource(R.drawable.googlemap),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop)
        }

        if (showDailog) {
            ViewUsers(onDismiss = {
                showDailog = false
            } ,
                userProfiles = userProfiles,
                navController)
            }
        }
    }


@Composable
fun ViewUserButton(
    showDialog: Boolean = false,
    onShowDialogChange: (Boolean) -> Unit = {}
) {
    FloatingActionButton(onClick = {
            onShowDialogChange(!showDialog)
    },
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.Gray
    ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "View Users"
            )
    }
}






@Preview(showBackground = true , showSystemUi = true)
@Composable
fun PreviewMap(){
    MapScreen(rememberNavController())

}