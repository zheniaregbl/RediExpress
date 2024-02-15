package ru.syndicate.rediexpress.ui.screens.track_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.data.model.PackageRouteStatus
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomOrange
import ru.syndicate.rediexpress.ui.theme.CustomSemiLightGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import java.time.LocalDate

@Composable
fun PackageRoute(
    modifier: Modifier = Modifier,
    text: String = "Courier requested",
    date: LocalDate = LocalDate.now(),
    status: PackageRouteStatus = PackageRouteStatus.NONE,
    isLast: Boolean = false
) {

    Box(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier
                .padding(start = 9.dp)
                .height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
                    .background(
                        color = if (!isLast) CustomGray else Color.Transparent
                    )
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = if (status == PackageRouteStatus.FINISH) MainBlue else CustomGray
                )

                Text(
                    text = "${date.month} ${date.dayOfMonth} ${date.year} " +
                            "08:00am",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = CustomOrange
                )

                if (!isLast)
                    Spacer(
                        modifier = Modifier
                            .height(12.dp)
                    )
            }
        }

        when(status) {

            PackageRouteStatus.FINISH -> {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .size(20.dp)
                        .background(
                            color = MainBlue
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        modifier = Modifier
                            .size(10.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_check),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            PackageRouteStatus.IN_PROGRESS -> {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .size(20.dp)
                        .background(
                            color = Color.White
                        )
                        .border(
                            width = 1.dp,
                            color = MainBlue,
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }

            PackageRouteStatus.NONE -> {

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .size(20.dp)
                        .background(
                            color = CustomSemiLightGray
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "—",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewPackageRoute() {
    PackageRoute(
        modifier = Modifier
            .padding(10.dp)
    )
}