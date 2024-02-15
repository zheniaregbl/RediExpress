package ru.syndicate.rediexpress.ui.screens.book_rider_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.RiderItem
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.extensions.containsUnwantedChar
import ru.syndicate.rediexpress.ui.screens.home_screen.components.SearchLine
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint

@SuppressLint("NewApi")
@Composable
fun BookRiderScreen(
    modifier: Modifier = Modifier,
    navigateToRider: (RiderItem) -> Unit = { },
    onClickBack: () -> Unit = { }
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val listRiders = listOf(
        RiderItem(
            name = "Name1",
            surname = "Surname1",
            number = "R-354-223U",
            stars = 3,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider1
        ),
        RiderItem(
            name = "Name2",
            surname = "Surname2",
            number = "R-354-223U",
            stars = 2,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider2
        ),
        RiderItem(
            name = "Name3",
            surname = "Surname3",
            number = "R-354-223U",
            stars = 5,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider3
        ),
        RiderItem(
            name = "Name4",
            surname = "Surname4",
            number = "R-354-223U",
            stars = 3,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider4
        ),
        RiderItem(
            name = "Name5",
            surname = "Surname5",
            number = "R-354-223U",
            stars = 5,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider5
        ),
        RiderItem(
            name = "Name6",
            surname = "Surname6",
            number = "R-354-223U",
            stars = 4,
            carModel = "Honda Accord",
            gender = "W",
            image = R.drawable.rider6
        ),
        RiderItem(
            name = "Name7",
            surname = "Surname7",
            number = "R-354-223U",
            stars = 5,
            carModel = "Honda Accord",
            gender = "W",
            image = R.drawable.rider7
        ),
        RiderItem(
            name = "Name8",
            surname = "Surname8",
            number = "R-354-223U",
            stars = 3,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider8
        ),
        RiderItem(
            name = "Name9",
            surname = "Surname9",
            number = "R-354-223U",
            stars = 4,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider9
        ),
        RiderItem(
            name = "Name10",
            surname = "Surname10",
            number = "R-354-223U",
            stars = 4,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider10
        ),
        RiderItem(
            name = "Name11",
            surname = "Surname11",
            number = "R-354-223U",
            stars = 5,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider11
        ),
        RiderItem(
            name = "Name12",
            surname = "Surname12",
            number = "R-354-223U",
            stars = 2,
            carModel = "Honda Accord",
            gender = "M",
            image = R.drawable.rider12
        )
    )

    Column(
        modifier = modifier
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = Color.White,
            shadowElevation = 12.dp
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 25.dp,
                        vertical = 18.dp
                    )
            ) {

                Icon(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) { onClickBack() }
                        .size(24.dp)
                        .rotate(180f),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow_square),
                    contentDescription = null,
                    tint = MainBlue
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Book a Rider",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = CustomGray
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp
                )
                .padding(
                    horizontal = 24.dp
                )
        ) {

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
                hintText = "Search for a driver",
                onValueChange = {
                    if (!it.containsUnwantedChar())
                        searchText = it
                }
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        top = 10.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                itemsIndexed(listRiders) { index, rider ->

                    Row(
                        modifier = Modifier
                            .padding(
                                top = if (index == 0) 14.dp else 0.dp,
                                bottom = if (index == listRiders.lastIndex) 14.dp else 0.dp
                            )
                            .advancedShadow(
                                color = Color.Black,
                                alpha = 0.4f,
                                shadowBlurRadius = 8.dp,
                                offsetY = 8.dp
                            )
                            .fillMaxWidth()
                            .background(
                                color = Color.White
                            )
                            .clickable {
                                navigateToRider(rider)
                            }
                            .padding(
                                vertical = 12.dp
                            ),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            modifier = Modifier
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        color = TextHint,
                                        shape = CircleShape
                                    ),
                                painter = painterResource(id = rider.image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )

                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {

                                Text(
                                    text = "${rider.surname} ${rider.name}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp,
                                    color = TextBlack
                                )

                                Text(
                                    text = rider.number,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp,
                                    color = TextBlack
                                )
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            repeat(rider.stars) {

                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_star),
                                    contentDescription = null,
                                    tint = MainBlue
                                )
                            }

                            repeat(5 - rider.stars) {

                                Icon(
                                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_star),
                                    contentDescription = null,
                                    tint = CustomGray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBookRiderScreen() {
    BookRiderScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}