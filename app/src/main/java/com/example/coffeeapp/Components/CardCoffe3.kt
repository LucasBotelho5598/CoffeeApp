import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Model.CoffeeCard
import com.example.coffeeapp.Model.CoffeeCard2
import com.example.coffeeapp.Model.CoffeeCard3
import com.example.coffeeapp.Model.coffeeList2
import com.example.coffeeapp.Model.coffeeList3
import com.example.coffeeapp.ui.theme.gilroy

@Preview
@Composable
fun CoffeeList3() {
    LazyRow {
        items(coffeeList3) { coffee3 ->
            CoffeeCard3(coffee3)
        }
    }
}

@Composable
fun CoffeeCard3(coffee3: CoffeeCard3) {
    Row(
        horizontalArrangement = Arrangement.Absolute.Right

    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(190.dp)
                .height(100.dp),
            backgroundColor = Color(0xFF272220).copy(0.5f)

        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(start = 20.dp, end = 90.dp, top = 10.dp, bottom = 10.dp)
                    .width(76.dp)
                    .height(76.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF37302D).copy(0.5f))
            ) {
                Icon(
                    painter = painterResource(id = coffee3.imageResId),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                )
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                Text(
                    modifier = Modifier.padding(start = 75.dp, top = 30.dp),
                    text = coffee3.name,
                    color = Color.White.copy(0.5f),
                    fontSize = 13.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(start = 75.dp, top = 5.dp),
                    text = coffee3.money,
                    color = Color(0xFFA97C37).copy(0.5f),
                    fontSize = 12.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }

        }
    }
}


