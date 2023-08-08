package com.example.jetpackcomposepractice

sealed class Screen(val route: String) {
    data object MainScreen : Screen(route = "MainScreen")
    data object DetailScreen : Screen(route = "DetailScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}