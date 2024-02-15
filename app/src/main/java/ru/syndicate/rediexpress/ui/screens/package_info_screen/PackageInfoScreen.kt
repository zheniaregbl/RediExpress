package ru.syndicate.rediexpress.ui.screens.package_info_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomOrange
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun PackageInfoScreen(
    modifier: Modifier = Modifier,
    isDelivered: Boolean = false,
    onClickBack: () -> Unit = { },
    navigateToAccept: () -> Unit = { },
    navigateToEdit: () -> Unit = { },
    onClickToMakePayment: () -> Unit = { }
) {

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

                if (isDelivered) {

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
                }

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = if (isDelivered) "Package Delivered" else "Send a package",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = CustomGray
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(
                    horizontal = 24.dp
                )
        ) {

            item {

                Column(
                    modifier = Modifier
                        .padding(
                            top = 24.dp
                        )
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        text = "Package Information",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = MainBlue
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(
                            text = "Origin details",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "Mbaraugba, Ovom Amaa Asaa, Abia state",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Text(
                            text = "+ 7 908 226 34 46",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(
                            text = "Destination details",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "19 Ademola Alabi close, lagos",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Text(
                            text = "+ 7 908 226 34 46",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(
                            text = "Other details",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Package Items",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomGray
                            )

                            Text(
                                text = "Books ans stationary, Garri Ngwa",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomOrange
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Weight of items",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomGray
                            )

                            Text(
                                text = "1000kg",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomOrange
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = "Tracking Number",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomGray
                            )

                            Text(
                                text = "R-7458-4567-4434-5854",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomOrange
                            )
                        }
                    }
                }
            }

            item {

                Spacer(
                    modifier = Modifier
                        .padding(
                            top = 36.dp,
                            bottom = 8.dp
                        )
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            color = CustomGray
                        )
                )
            }

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        text = "Charges",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = MainBlue
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Delivery Charges",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Text(
                            text = "N2,500.00",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomOrange
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Instant delivery",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Text(
                            text = "N300.00",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomOrange
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Tax and Service Charges",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomGray
                        )

                        Text(
                            text = "N200.00",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = CustomOrange
                        )
                    }
                }
            }

            item {

                Spacer(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            bottom = 4.dp
                        )
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(
                            color = CustomGray
                        )
                )
            }

            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Package total",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = CustomGray
                    )

                    Text(
                        text = "N3000.00",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = CustomOrange
                    )
                }
            }

            item {

                Row(
                    modifier = Modifier
                        .padding(
                            vertical = 46.dp
                        )
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .border(
                                width = 2.dp,
                                color = MainBlue,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .clickable {
                                if (!isDelivered)
                                    navigateToEdit()
                            }
                            .padding(
                                vertical = 15.dp
                            ),
                        text = if (isDelivered) "Report" else "Edit package",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = MainBlue
                    )

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                color = MainBlue
                            )
                            .clickable {
                                if (isDelivered) navigateToAccept() else onClickToMakePayment()
                            }
                            .padding(
                                vertical = 15.dp
                            ),
                        text = if (isDelivered) "Successful" else "Make payment",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPackageInfoScreen() {
    PackageInfoScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}