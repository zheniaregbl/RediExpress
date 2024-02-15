package ru.syndicate.rediexpress.ui.screens.profile_screen

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.ProfileListItem
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.ui.common.BalanceText
import ru.syndicate.rediexpress.ui.common.CustomSwitch
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomRed
import ru.syndicate.rediexpress.ui.theme.TextBlack

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {

    var isVisibleBalance by remember {
        mutableStateOf(true)
    }
    var darkMode by remember {
        mutableStateOf(false)
    }

    val listProfileItem = listOf(
        ProfileListItem(
            title = "Edit Profile",
            description = "Name, phone no, address, email ...",
            image = R.drawable.svg_nav_profile
        ),
        ProfileListItem(
            title = "Statements & Reports",
            description = "Download transaction details, orders, deliveries",
            image = R.drawable.svg_reports
        ),
        ProfileListItem(
            title = "Notification Settings",
            description = "mute, unmute, set location & tracking setting",
            image = R.drawable.svg_bell
        ),
        ProfileListItem(
            title = "Card & Bank account settings",
            description = "change cards, delete card details",
            image = R.drawable.svg_card_bank
        ),
        ProfileListItem(
            title = "Referrals",
            description = "check no of friends and earn",
            image = R.drawable.svg_referrals
        ),
        ProfileListItem(
            title = "About Us",
            description = "know more about us, terms and conditions",
            image = R.drawable.svg_about
        ),
        ProfileListItem(
            title = "Log Out",
            description = "",
            image = R.drawable.svg_logout
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

                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Profile",
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

            Row(
                modifier = Modifier
                    .padding(
                        top = 25.dp
                    )
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Enable dark mode",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = TextBlack
                )

                CustomSwitch(
                    switchPadding = 2.dp,
                    buttonWidth = 44.dp,
                    buttonHeight = 24.dp,
                    value = darkMode,
                    onSwitch = { darkMode = !darkMode }
                )
            }

            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = 8.dp
                    )
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                itemsIndexed(listProfileItem) { index, item ->

                    Row(
                        modifier = Modifier
                            .padding(
                                top = if (index == 0) 12.dp else 0.dp,
                                bottom = if (index == listProfileItem.lastIndex) 12.dp else 0.dp
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
                            .clickable {  }
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            modifier = Modifier
                                .weight(1f),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Icon(
                                modifier = Modifier
                                    .size(20.dp),
                                imageVector = ImageVector.vectorResource(id = item.image),
                                contentDescription = null,
                                tint = if (index == listProfileItem.lastIndex) CustomRed
                                else TextBlack
                            )

                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {

                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp,
                                    color = TextBlack
                                )

                                if (item.description.isNotEmpty())
                                    Text(
                                        text = item.description,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 12.sp,
                                        color = CustomGray
                                    )
                            }
                        }

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_arrow),
                            contentDescription = null,
                            tint = TextBlack
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
fun PreviewProfileScreen() {
    ProfileScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}