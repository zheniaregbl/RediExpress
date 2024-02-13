package ru.syndicate.rediexpress.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.ServiceItem
import ru.syndicate.rediexpress.extensions.containsUnwantedChar
import ru.syndicate.rediexpress.ui.screens.home_screen.components.SearchLine
import ru.syndicate.rediexpress.ui.screens.home_screen.components.ServiceCard
import ru.syndicate.rediexpress.ui.theme.CustomOrange
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextHint

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToNotification: () -> Unit = { }
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val listImages = listOf(
        R.drawable.ads1, R.drawable.ads2,
        R.drawable.ads3, R.drawable.ads4,
        R.drawable.ads5
    )
    val listService = listOf(
        ServiceItem(
            image = R.drawable.svg_head,
            title = "Customer Care",
            description = "Our customer care service line is available from 8 -9pm week days and 9 - 5 weekends - tap to call us today"
        ),
        ServiceItem(
            image = R.drawable.svg_box,
            title = "Send a package",
            description = "Request for a driver to pick up or deliver your package for you"
        ),
        ServiceItem(
            image = R.drawable.svg_wallet,
            title = "Fund your wallet",
            description = "To fund your wallet is as easy as ABC, make use of our fast technology and top-up your wallet today"
        ),
        ServiceItem(
            image = R.drawable.svg_car,
            title = "Book a Rider",
            description = "Search for available driver within your area"
        )
    )

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp
                )
        ) {

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            SearchLine(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .fillMaxWidth()
                    .background(
                        color = TextHint
                    )
                    .padding(
                        horizontal = 12.dp,
                        vertical = 9.dp
                    ),
                value = searchText,
                hintText = "Search services",
                onValueChange = {
                    if (!it.containsUnwantedChar())
                        searchText = it
                }
            )

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .background(
                        color = MainBlue
                    )
                    .clickable { navigateToNotification() }
                    .padding(
                        horizontal = 12.dp,
                        vertical = 24.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {

                    Text(
                        text = "Hello Ken",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        color = Color.White
                    )

                    Text(
                        text = "We trust you are having a great time",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_bell),
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Special for you",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomOrange
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_square),
                    contentDescription = null,
                    tint = CustomOrange
                )
            }

            Spacer(
                modifier = Modifier
                    .height(7.dp)
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                items(listImages) { image ->

                    Image(
                        modifier = Modifier
                            .size(166.dp, 64.dp),
                        painter = painterResource(id = image),
                        contentDescription = null
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(30.dp)
            )

            Text(
                text = "What would you like to do",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = MainBlue
            )

            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {

                items((listService.size + 1) / 2) { i ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {

                        for (j in 0 until 2) {

                            val index = i * 2 + j

                            if (index < listService.size) {

                                ServiceCard(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(1f),
                                    image = listService[index].image,
                                    title = listService[index].title,
                                    description = listService[index].description
                                )
                            }
                        }
                    }
                }

                item {

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}