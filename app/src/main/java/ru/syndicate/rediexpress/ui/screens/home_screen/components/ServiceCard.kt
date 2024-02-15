package ru.syndicate.rediexpress.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.CustomLightGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@Composable
fun ServiceCard(
    modifier: Modifier = Modifier,
    image: Int = R.drawable.svg_head,
    title: String = "Customer Care",
    description: String = "Our customer care service line is available" +
            " from 8 -9pm week days and 9 - 5 weekends - tap to call us today",
    onClick: () -> Unit = { }
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = if (isPressed) MainBlue else CustomLightGray
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            }
            .padding(
                start = 12.dp,
                top = 22.dp,
                end = 20.dp,
                bottom = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        Icon(
            modifier = Modifier
                .height(36.dp),
            imageVector = ImageVector.vectorResource(id = image),
            contentDescription = null,
            tint = if (isPressed) Color.White else MainBlue
        )

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = if (isPressed) Color.White else MainBlue
        )

        Text(
            modifier = Modifier
                .padding(
                    bottom = 0.dp
                ),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            color = if (isPressed) Color.White else TextBlack,
            lineHeight = 10.sp
        )
    }
}