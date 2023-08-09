package com.example.jetpackcomposepractice

import androidx.annotation.StringRes

sealed class Bottom(val route: String, @StringRes val resourceId: Int) {
    data object Profile : Bottom("profile", R.string.profile)
    data object FriendsList : Bottom("friendslist", R.string.friends_list)
}
