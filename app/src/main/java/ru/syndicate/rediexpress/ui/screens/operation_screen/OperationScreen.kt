package ru.syndicate.rediexpress.ui.screens.operation_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun OperationScreen(
    modifier: Modifier = Modifier,
    isDelivery: Boolean = false,
    navigateToTrackItem: () -> Unit = { },
    navigateToHome: () -> Unit = { }
) {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            resId = R.raw.successful_lottie
        )
    )
    var isPlaying by remember {
        mutableStateOf(true)
    }

    val progress by animateLottieCompositionAsState(
        composition =  composition,
        isPlaying = isPlaying,
        iterations = 1,
        speed = .85f
    )

    LaunchedEffect(progress) {
        if (progress == 1f) {
            isPlaying = false
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        if (!isDelivery) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 24.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LottieAnimation(
                    modifier = Modifier
                        .size(120.dp),
                    composition = composition,
                    progress = { progress }
                )

                Spacer(
                    modifier = Modifier
                        .height(75.dp)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Text(
                        text = "Transaction Successful",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 24.sp,
                        color = TextBlack
                    )

                    Text(
                        text = "Your rider is on the way to your destination",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = TextBlack
                    )

                    Row {

                        Text(
                            text = "Tracking Number ",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = TextBlack
                        )

                        Text(
                            text = "R-7458-4567-4434-5854",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = MainBlue
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(135.dp)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            color = MainBlue
                        )
                        .clickable {
                            navigateToTrackItem()
                        }
                        .padding(
                            vertical = 15.dp
                        ),
                    text = "Track my item",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .border(
                            width = 1.dp,
                            color = MainBlue,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clickable {
                            navigateToHome()
                        }
                        .padding(
                            vertical = 15.dp
                        ),
                    text = "Go back to homepage",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = MainBlue
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewOperationScreen() {
    OperationScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}