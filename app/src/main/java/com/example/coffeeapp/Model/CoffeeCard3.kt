package com.example.coffeeapp.Model

import com.example.coffeeapp.R


data class CoffeeCard3(val name: String, val imageResId: Int, val money: String)

val coffeeList3 = listOf(
    CoffeeCard3("Coffee", R.drawable.chailatte,"$85.00"),
    CoffeeCard3("Coffee", R.drawable.matchalatte,"$22.00"),
    CoffeeCard3("Coffee", R.drawable.redeyes,"$60.00")
)