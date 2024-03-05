package com.example.coffeeapp.Auth


import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.coffeeapp.HOME_SCREEN_COFFE
import com.example.coffeeapp.SIGN_IN
import com.example.coffeeapp.Services.AccountService
import com.example.coffeeapp.Splash.CoffeeAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject



@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService,
) : CoffeeAppViewModel() {



    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun updatePhone(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword

    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signIn(email.value, password.value)
            openAndPopUp(HOME_SCREEN_COFFE, SIGN_IN)

        }
    }
}