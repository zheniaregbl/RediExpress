package ru.syndicate.rediexpress.ui.screens.rider_profile_screen

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.mapview.MapView
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.CustomerReviewItem
import ru.syndicate.rediexpress.data.model.RiderItem
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.extensions.gesturesDisabled
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomOrange
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint

@Composable
fun RiderProfileScreen(
    modifier: Modifier = Modifier,
    mapView: MapView? = null,
    rider: RiderItem = RiderItem(
        name = "Name11",
        surname = "Surname11",
        number = "R-354-223U",
        stars = 5,
        carModel = "Honda Accord",
        gender = "M",
        image = R.drawable.rider11
    ),
    onClickBack: () -> Unit = { }
) {

    val listReview = listOf(
        CustomerReviewItem(
            name = "name1",
            surname = "surname1",
            comment = "Right on time",
            stars = 5,
            image = R.drawable.rider4
        ),
        CustomerReviewItem(
            name = "name2",
            surname = "surname2",
            comment = "Right on time",
            stars = 4,
            image = R.drawable.rider1
        ),
        CustomerReviewItem(
            name = "name3",
            surname = "surname3",
            comment = ":(",
            stars = 1,
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
                    text = "Rider profile",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = CustomGray
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            if (mapView == null) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(212.dp)
                        .background(
                            color = Color.DarkGray
                        )
                )
            } else {

                AndroidView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(212.dp)
                        .gesturesDisabled(
                            disabled = true
                        ),
                    factory = {
                        mapView
                    }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 156.dp
                    )
                    .padding(
                        horizontal = 24.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Image(
                    modifier = Modifier
                        .size(84.dp)
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

                Text(
                    text = "${rider.surname} ${rider.name}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MainBlue
                )

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

        Row(
            modifier = Modifier
                .padding(
                    top = 16.dp
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Car Model",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomOrange
                )

                Text(
                    text = rider.carModel,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomGray
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Registration Number",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomOrange
                )

                Text(
                    text = rider.number,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomGray
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Gender",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomOrange
                )

                Text(
                    text = rider.gender,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomGray
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 26.dp
                )
                .padding(
                    horizontal = 24.dp
                ),
            text = "Customer Reviews",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = TextBlack
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = 4.dp
                )
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            itemsIndexed(listReview) { index, review ->

                Row(
                    modifier = Modifier
                        .padding(
                            top = if (index == 0) 4.dp else 0.dp,
                            bottom = if (index == listReview.lastIndex) 10.dp else 0.dp
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
                            painter = painterResource(id = review.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            Text(
                                text = "${review.surname} ${review.name}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = TextBlack
                            )

                            Text(
                                text = review.comment,
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

                        repeat(review.stars) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_star),
                                contentDescription = null,
                                tint = MainBlue
                            )
                        }

                        repeat(5 - review.stars) {

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

@Preview
@Composable
fun PreviewRiderProfileScreen() {
    RiderProfileScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}