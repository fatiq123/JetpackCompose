package com.example.jetpackcomposepractice.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    // 1. we have to create a navController
    val navController = rememberNavController()
    // 2. we have to create a navHost
    NavHost(navController = navController, startDestination = "MainScreen") {

        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }

        composable(route = Screen.DetailScreen.route + "/{name}",
            listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "User"
                    nullable = true
                }

            )) { backStackEntry ->
            DetailScreen(name = backStackEntry.arguments?.getString("name"))
        }
    }
}


@Composable
fun MainScreen(navController: NavController) {

    var textField by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = textField, onValueChange = {
                textField = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(Screen.DetailScreen.withArgs(textField))
        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "Go to detail Screen", color = Color.White)
        }
    }
}

@Composable
fun DetailScreen(name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),

    ) {
        Text(text = "Hello $name", textAlign = TextAlign.Center)
    }
}