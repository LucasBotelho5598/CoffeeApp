package com.example.coffeeapp.Components


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.gilroy


@RequiresApi(Build.VERSION_CODES.M)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun SearchBar3() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        singleLine = true,
        shape = RoundedCornerShape(9.dp),
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                "Coffee shop, beer & wine...",
                fontSize = 16.sp,
                fontFamily = gilroy,
                color = Color(0xFF55433C)
            )
        },
        modifier = Modifier
            .width(335.dp)
            .height(50.dp)
            .fillMaxSize()
            .fillMaxWidth(),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.settings),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = null,
                modifier = Modifier.size(20.dp)

            )

        },


        )


}