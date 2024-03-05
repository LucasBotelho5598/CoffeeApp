package com.example.coffeeapp.Onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.Components.ButtonCoffee
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.gilroy


@Composable
fun Onboarding(navController: NavController) {
    Box(
        modifier = Modifier
            .background(Color(0xFF55433C))
            .fillMaxSize()
    ) {

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backgroundcoffee),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .absolutePadding(top = 40.dp)
                .absoluteOffset(y = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_coffee),
                contentDescription = null,
                modifier = Modifier.size(52.dp)
            )
            Text(
                textAlign = TextAlign.Center,
                text = "COFFEE TASTE!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = gilroy,
                fontSize = 14.sp,
                letterSpacing = 8.sp
            )

        }

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .absolutePadding(top = 90.dp)
                .padding(top = 90.dp)
                .absoluteOffset(y = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(70.dp))
            Text(
                text = "Find your favorite",
                color = Color.White,
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Coffee Taste!",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = gilroy,

                )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "We’re coffee shop, beer and wine bar,\n" +
                        "& event space for performing arts",
                color = Color.White.copy(0.7f),
                fontSize = 16.sp,
            )

        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .absolutePadding(bottom = 50.dp)
        ) {
            ButtonCoffee(
                navController
            )

        }

    }
}