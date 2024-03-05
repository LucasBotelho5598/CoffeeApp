package com.example.coffeeapp.Model


import com.example.coffeeapp.R


data class CoffeeCard2(val name: String, val imageResId: Int, val money: String)

val coffeeList2 = listOf(
    CoffeeCard2("Coffee", R.drawable.chailatte,"$22.00"),
    CoffeeCard2("Coffee", R.drawable.matchalatte,"$85.00"),
    CoffeeCard2("Coffee", R.drawable.redeyes,"$60.00")
)


