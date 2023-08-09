package com.example.jetpackcomposepractice

import android.provider.ContactsContract
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    androidx.compose.material.BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 4.dp
    ) {
        items.forEach { item ->
            val selected = item.name == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected, onClick = { onItemClick(item) }, icon = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    if (item.badgeCount > 0) {
                        BadgedBox(badge = {
                            Badge {
                                Text(text = item.badgeCount.toString())
                            }
                        }) {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                    } else {
                        Icon(imageVector = item.icon, contentDescription = item.name)
                    }
                    if (selected) {
                        /*Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.dp,
                            color = Color.Blue
                        )*/
                    }
                }
            }, selectedContentColor = Color.Blue, unselectedContentColor = Color.Gray)
        }

    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Settings Screen")
    }
}