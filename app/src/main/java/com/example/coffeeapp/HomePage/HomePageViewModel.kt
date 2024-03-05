package com.example.coffeeapp.HomePage


import com.example.coffeeapp.ONBOARDING
import com.example.coffeeapp.SIGN_IN
import com.example.coffeeapp.Services.AccountService
import com.example.coffeeapp.Splash.CoffeeAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val accountService: AccountService,
    ) : CoffeeAppViewModel() {

    fun initialize(restartApp: (String) -> Unit) {
        launchCatching {
            accountService.currentUser.collect { SigIn ->
                if (SigIn == null) restartApp(ONBOARDING)
            }
        }
    }



}