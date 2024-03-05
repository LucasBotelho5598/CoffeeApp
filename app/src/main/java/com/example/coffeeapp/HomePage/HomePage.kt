package com.example.coffeeapp.HomePage

import CoffeeList
import CoffeeList2
import CoffeeList3
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffeeapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coffeeapp.Components.AssistChipExample
import com.example.coffeeapp.Components.SearchBar3
import com.example.coffeeapp.Model.coffeeList2
import com.example.coffeeapp.NavigationBar.BottomNavigationBar
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import com.example.coffeeapp.ui.theme.gilroy

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun HomePage(
    restartApp: (String) -> Unit,
    viewModel: HomePageViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) { viewModel.initialize(restartApp) }

    Box(
        modifier = Modifier
            .background(Color(0xFF201B18))
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.backgroundhome),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .absolutePadding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_coffee),
                contentDescription = null,
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "COFFEE\nTATES!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = gilroy,
                fontSize = 12.sp,
                letterSpacing = 8.sp
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .absolutePadding(top = 60.dp, left = 16.dp)
                .padding(vertical = 25.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.clipuser),
                contentDescription = null,
                modifier = Modifier.size(42.dp)
            )
        }
        Row(
            modifier = Modifier
                .absolutePadding(top = 40.dp, right = 16.dp)
                .absoluteOffset(y = 20.dp)
                .padding(vertical = 30.dp)
                .align(Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .absolutePadding(top = 80.dp, left = 12.dp)
                .padding(vertical = 70.dp)
        ) {
            Text(
                text = "Hi,",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontFamily = gilroy,
                fontSize = 30.sp,

                )
            Text(
                text = "William",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = gilroy,
                fontSize = 30.sp,
            )


        }
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .absolutePadding(top = 70.dp)
                .padding(vertical = 80.dp)
                .absoluteOffset(y = 60.dp, x = 20.dp)
        ) {
            SearchBar3()
            Spacer(modifier = Modifier.padding(3.dp))


        }

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .absolutePadding(top = 60.dp)
                .padding(top = 70.dp)
                .padding(vertical = 80.dp)
                .absoluteOffset(y = 60.dp, x = 14.dp)
        ) {
            AssistChipExample()
            CoffeeList()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(210.dp),
                modifier = Modifier.absolutePadding(top = 10.dp, right = 16.dp)
            ) {
                Text(
                    "Frozen Beverages",
                    fontSize = 14.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFFFFFFF)
                )

                Text(
                    "See All",
                    fontSize = 12.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFA97C37),
                    textDecoration = TextDecoration.Underline
                )
            }
            CoffeeList2()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(140.dp),
                modifier = Modifier.absolutePadding(top = 10.dp, right = 16.dp)
            ) {
                Text(
                    "Kava and Bottled Beverages",
                    fontSize = 14.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFFFFFFF).copy(alpha = 0.5f),
                    modifier = Modifier.align(Alignment.Top)

                )
                Text(
                    "See All",
                    fontSize = 12.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFA97C37),
                    textDecoration = TextDecoration.Underline
                )
            }
            CoffeeList3()


        }
        BottomNavigationBar()

    }
}


@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun HomePagePreview() {
    CoffeeAppTheme {
        HomePage({ })
    }
}