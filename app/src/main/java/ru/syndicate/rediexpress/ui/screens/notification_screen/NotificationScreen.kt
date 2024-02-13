package ru.syndicate.rediexpress.ui.screens.notification_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = { }
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
                    text = "Notification",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = CustomGray
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                Icon(
                    modifier = Modifier
                        .size(83.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_bell),
                    contentDescription = null,
                    tint = CustomGray
                )

                Text(
                    text = "You have no notifications",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = TextBlack
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNotificationScreen() {
    NotificationScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}