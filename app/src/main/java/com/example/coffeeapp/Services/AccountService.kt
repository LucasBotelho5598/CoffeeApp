package com.example.coffeeapp.Services

import com.example.coffeeapp.Model.User
import kotlinx.coroutines.flow.Flow


interface AccountService {
    val currentUser: Flow<User>
    suspend fun signIn(phone: String, password: String)
}