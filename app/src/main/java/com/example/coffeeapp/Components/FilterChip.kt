package com.example.coffeeapp.Components

import android.provider.CalendarContract
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffeeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AssistChipExample() {


    val itemsList = listOf(
        "Coffee",
        "Beer",
        "Wine Bar",
        "Event"
    )

    val iconList = listOf(
        R.drawable.coffee,
        R.drawable.bear,
        R.drawable.vinho,
        R.drawable.event

    )

    val union = itemsList zip iconList



    var selectedItem by remember {
        mutableStateOf(itemsList[0])
    }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(union) { (item, icon) ->
            InputChip(
                shape = RoundedCornerShape(50.dp),
                colors = FilterChipDefaults.filterChipColors(
                    labelColor = Color.White,
                    selectedLabelColor = Color.White,
                    selectedLeadingIconColor = Color(0xFF55433C),
                    selectedContainerColor = Color(0xFFA97C37)

                ),
                modifier = Modifier.padding(horizontal = 6.dp),
                selected = (item == selectedItem),
                onClick = { selectedItem = item },
                label = {
                    Text(text = item)
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)

                    )
                }
            )
        }
    }

}


