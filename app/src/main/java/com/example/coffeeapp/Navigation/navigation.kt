package com.example.coffeeapp.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeapp.CoffeAppState
import com.example.coffeeapp.HOME_SCREEN_COFFE
import com.example.coffeeapp.HomePage.HomePage
import com.example.coffeeapp.ONBOARDING
import com.example.coffeeapp.Onboarding.Onboarding
import com.example.coffeeapp.SIGN_IN
import com.google.firebase.quickstart.auth.kotlin.SignInScreen

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun Navigation() {

    val appState = rememberAppState()

    NavHost(
        navController = appState.navController,
        startDestination = ONBOARDING,
    ){
        CoffeeGraph(appState)

    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        CoffeAppState(navController)
    }

@RequiresApi(Build.VERSION_CODES.M)
fun NavGraphBuilder.CoffeeGraph(appState: CoffeAppState){
    composable(HOME_SCREEN_COFFE){
        HomePage(
            restartApp = { route -> appState.clearAndNavigate(route) },
        )
    }

    composable(SIGN_IN){
        SignInScreen(openAndPopUp = { route, popUp -> appState.navigateAndPopUp(route, popUp) })
    }

    composable(ONBOARDING){
        Onboarding(appState.navController)
    }
}


