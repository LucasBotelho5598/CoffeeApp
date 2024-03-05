package com.example.coffeeapp.NavigationBar

import com.example.coffeeapp.R


sealed class NavigationItem(var route: String, var icon: Int){
    data object Dashboard: NavigationItem("dashboard", R.drawable.dashboard,)
    data object Heart: NavigationItem("heart", R.drawable.heart,)
    data object Shopping: NavigationItem("shopping", R.drawable.shopping,)
    data object Person: NavigationItem("person", R.drawable.person,)

}