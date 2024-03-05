import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.Model.CoffeeCard
import com.example.coffeeapp.Model.coffeeList
import com.example.coffeeapp.ui.theme.gilroy


@Composable
fun CoffeeList() {
    LazyRow {
        items(coffeeList) { coffee ->
            CoffeeCard(coffee)
        }
    }
}

@Composable
fun CoffeeCard(coffee: CoffeeCard) {

    var selectBox by remember {
        mutableStateOf(false)
    }

    Row(
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(12.dp))
                .width(120.dp)
                .height(150.dp),
            backgroundColor = Color(0xFF272220)

        ) {
            Box(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 60.dp, start = 20.dp, end = 20.dp)
                    .align(Alignment.Bottom)
                    .clip(CircleShape)
                    .background(if (selectBox) Color(0xFFA97C37) else Color(0xFF37302D))
            ) {
                Icon(
                    painter = painterResource(id = coffee.imageResId),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = coffee.name,
                modifier = Modifier
                    .padding(start = 20.dp, top = 100.dp, end = 20.dp)
                    .align(Alignment.CenterVertically),
                color = Color.White,
                fontSize = 13.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center

            )
            Text(
                text = coffee.money,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top=20.dp).absolutePadding(top=60.dp).absoluteOffset(y=40.dp)
                    .align(Alignment.CenterVertically),
                color = Color(0xFFA97C37),
                fontSize = 13.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center

            )
        }
    }
}


