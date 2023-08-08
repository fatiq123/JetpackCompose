package com.example.jetpackcomposepractice

sealed class Screen (val route: String) {
    data object MainScreen: Screen(route = "MainScreen")
    data object DetailScreen: Screen(route = "DetailScreen")
}