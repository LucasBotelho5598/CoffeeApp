package com.example.coffeeapp.Components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeeapp.R
import com.example.coffeeapp.SIGN_IN
import com.example.coffeeapp.ui.theme.gilroy


@Composable
fun ButtonCoffee(
    navController: NavController
) {

    Button(
        colors = ButtonDefaults.buttonColors(Color(0xFF55433C)),
        shape = RoundedCornerShape(9.dp),
        onClick = {
            navController.navigate(SIGN_IN)
        },
        modifier = Modifier.width(272.dp).height(56.dp)
    ) {
        Text(
            "Get Started",
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .offset(x = 8.dp),
            fontSize = 18.sp,
            fontFamily = gilroy,
            fontWeight = FontWeight.Bold
        )
        Icon(
            contentDescription = null,
            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
            modifier = Modifier.size(35.dp),
            tint = Color.White
        )


    }

}