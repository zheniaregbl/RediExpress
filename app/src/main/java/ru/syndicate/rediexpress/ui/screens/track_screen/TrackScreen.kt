package ru.syndicate.rediexpress.ui.screens.track_screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.mapview.MapView
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.PackageRouteStatus
import ru.syndicate.rediexpress.ui.screens.track_screen.components.PackageRoute
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun TrackScreen(
    modifier: Modifier = Modifier,
    mapView: MapView? = null,
    navigateToInfo: () -> Unit = { }
) {

    Column(
        modifier = modifier
    ) {

        if (mapView == null) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(275.dp)
                    .background(
                        color = Color.DarkGray
                    )
            )
        } else {

            AndroidView(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(275.dp),
                factory = {
                    mapView
                }
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 42.dp
                )
                .padding(
                    horizontal = 24.dp
                ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Tracking Number",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = TextBlack
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_dot),
                    contentDescription = null
                )

                Text(
                    text = "R-7458-4567-4434-5854",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = MainBlue
                )
            }
        }

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp
                ),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            item {

                Text(
                    text = "Package Status",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomGray
                )
            }


            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    for (i in 0..3) {

                        PackageRoute(
                            status = when(i) {
                                2 -> PackageRouteStatus.IN_PROGRESS
                                3 -> PackageRouteStatus.NONE
                                else -> PackageRouteStatus.FINISH
                            },
                            isLast = i == 3
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )
            }

            item {

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            color = MainBlue
                        )
                        .clickable {
                            navigateToInfo()
                        }
                        .padding(
                            vertical = 15.dp
                        ),
                    text = "View Package Info",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTrackScreen() {
    TrackScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}