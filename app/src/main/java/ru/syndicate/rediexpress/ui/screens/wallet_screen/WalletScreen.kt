package ru.syndicate.rediexpress.ui.screens.wallet_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.TransactionItem
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.ui.common.BalanceText
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomGreen
import ru.syndicate.rediexpress.ui.theme.CustomRed
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint
import java.time.LocalDate
import kotlin.math.abs

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun WalletScreen(
    modifier: Modifier = Modifier
) {

    var isVisibleBalance by remember {
        mutableStateOf(true)
    }

    val listTransaction = listOf(
        TransactionItem(
            text = "Top up",
            date = LocalDate.of(2024, 1, 12),
            value = 10000.0
        ),
        TransactionItem(
            text = "Delivery fee",
            date = LocalDate.of(2024, 1, 24),
            value = -1200.0
        ),
        TransactionItem(
            text = "Delivery fee",
            date = LocalDate.of(2024, 1, 25),
            value = -2500.0
        ),
        TransactionItem(
            text = "Top up",
            date = LocalDate.of(2024, 2, 3),
            value = 2000.0
        ),
        TransactionItem(
            text = "Delivery fee",
            date = LocalDate.of(2024, 2, 11),
            value = -3000.0
        ),
        TransactionItem(
            text = "Delivery fee",
            date = LocalDate.of(2024, 2, 12),
            value = -500.0
        ),
        TransactionItem(
            text = "Delivery fee",
            date = LocalDate.of(2024, 2, 12),
            value = -200.0
        ),
        TransactionItem(
            text = "Top up",
            date = LocalDate.of(2024, 2, 13),
            value = 1000.0
        ),
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

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Wallet",
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
                    top = 36.dp
                )
                .padding(
                    horizontal = 24.dp
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .size(60.dp),
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = null
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Text(
                            text = "Ken Nwaeze",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = TextBlack
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            Text(
                                text = "Current balance:",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = TextBlack
                            )

                            BalanceText(
                                value = 2000.0,
                                isVisible = isVisibleBalance
                            )
                        }
                    }
                }

                IconButton(
                    onClick = { isVisibleBalance = !isVisibleBalance }
                ) {

                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        imageVector = ImageVector.vectorResource(
                            id = if (isVisibleBalance) R.drawable.svg_password_hide
                            else R.drawable.svg_password_show
                        ),
                        contentDescription = null,
                        tint = TextBlack
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(
                        top = 45.dp
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .background(
                        color = TextHint
                    )
                    .padding(
                        vertical = 10.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = "Top Up",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = TextBlack
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(50.dp)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp)
                                .background(
                                    color = MainBlue
                                )
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_bank),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Bank",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp)
                                .background(
                                    color = MainBlue
                                )
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_transfer),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Transfer",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(48.dp)
                                .background(
                                    color = MainBlue
                                )
                                .clickable { },
                            contentAlignment = Alignment.Center
                        ) {

                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.svg_card),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Text(
                            text = "Card",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = TextBlack
                        )
                    }
                }
            }

            Text(
                modifier = Modifier
                    .padding(
                        top = 90.dp
                    ),
                text = "Transaction History",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = TextBlack
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                itemsIndexed(listTransaction) { index, item ->

                    Row(
                        modifier = Modifier
                            .padding(
                                top = if (index == 0) 12.dp else 0.dp,
                                bottom = if (index == listTransaction.lastIndex) 12.dp else 0.dp
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
                                horizontal = 12.dp,
                                vertical = 4.dp
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {

                            Text(
                                text = item.text,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = TextBlack
                            )

                            Text(
                                text = "${item.date.month} ${item.date.dayOfMonth}, ${item.date.year}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = CustomGray
                            )
                        }

                        Text(
                            text = if (item.value < 0) "-N${abs(item.value)}" else "N${item.value}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            color = if (item.value < 0) CustomRed else CustomGreen
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun PreviewWalletScreen() {
    WalletScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}