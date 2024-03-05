package com.example.coffeeapp.Model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import com.example.coffeeapp.R


data class CoffeeCard(val name: String, val imageResId: Int, val money: String)


val coffeeList = listOf(
    CoffeeCard("Chai Latte", R.drawable.chailatte, "$85.00"),
    CoffeeCard("Matcha Latte", R.drawable.matchalatte, "$22.00"),
    CoffeeCard("Red Eye Cold", R.drawable.redeyes, "$60.00")
)

