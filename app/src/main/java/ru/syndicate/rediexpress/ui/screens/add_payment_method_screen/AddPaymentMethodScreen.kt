package ru.syndicate.rediexpress.ui.screens.add_payment_method_screen

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.SelectedLightBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun AddPaymentMethodScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = { },
    navigateToNext: () -> Unit = { }
) {

    var selectedItem by remember {
        mutableIntStateOf(-1)
    }

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
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
                        text = "Add payment method",
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
                        top = 66.dp
                    )
                    .padding(
                        horizontal = 24.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    modifier = Modifier
                        .advancedShadow(
                            color = Color.Black,
                            alpha = 0.4f,
                            shadowBlurRadius = 8.dp,
                            offsetY = 8.dp
                        )
                        .fillMaxWidth()
                        .background(
                            color = if (selectedItem == 0) SelectedLightBlue else Color.White
                        )
                        .clickable {
                            selectedItem = 0
                        }
                        .padding(
                            horizontal = 8.dp,
                            vertical = 24.dp
                        ),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(14.dp)
                            .background(
                                color = Color.Transparent
                            )
                            .border(
                                width = 1.dp,
                                color = MainBlue,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(9.dp)
                                .background(
                                    color = MainBlue
                                )
                        )
                    }

                    Column {

                        Text(
                            text = "Pay with wallet",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "complete the payment using your e wallet",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = CustomGray
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .advancedShadow(
                            color = Color.Black,
                            alpha = 0.4f,
                            shadowBlurRadius = 8.dp,
                            offsetY = 8.dp
                        )
                        .fillMaxWidth()
                        .background(
                            color = if (selectedItem == 1) SelectedLightBlue else Color.White
                        )
                        .clickable {
                            selectedItem = 1
                        }
                        .padding(
                            horizontal = 8.dp,
                            vertical = 24.dp
                        ),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(14.dp)
                            .background(
                                color = Color.Transparent
                            )
                            .border(
                                width = 1.dp,
                                color = MainBlue,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(9.dp)
                                .background(
                                    color = MainBlue
                                )
                        )
                    }

                    Column {

                        Text(
                            text = "Credit / debit card",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "add new card",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = CustomGray
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .advancedShadow(
                            color = Color.Black,
                            alpha = 0.4f,
                            shadowBlurRadius = 8.dp,
                            offsetY = 8.dp
                        )
                        .fillMaxWidth()
                        .background(
                            color = if (selectedItem == 2) SelectedLightBlue else Color.White
                        )
                        .clickable {
                            selectedItem = 2
                        }
                        .padding(
                            horizontal = 8.dp,
                            vertical = 24.dp
                        ),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(14.dp)
                            .background(
                                color = Color.Transparent
                            )
                            .border(
                                width = 1.dp,
                                color = MainBlue,
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(9.dp)
                                .background(
                                    color = MainBlue
                                )
                        )
                    }

                    Column {

                        Text(
                            text = "**** **** 3323",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "remove card",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = CustomGray
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    bottom = 100.dp
                )
                .padding(
                    horizontal = 24.dp
                )
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(
                    color = MainBlue
                )
                .clickable {
                    navigateToNext()
                }
                .padding(
                    vertical = 15.dp
                ),
            text = "Proceed to pay",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PreviewAddPaymentMethodScreen() {
    AddPaymentMethodScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}