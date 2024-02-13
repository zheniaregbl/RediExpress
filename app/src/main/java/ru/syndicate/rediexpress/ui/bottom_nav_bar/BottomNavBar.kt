package ru.syndicate.rediexpress.ui.bottom_nav_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.data.model.BottomNavBarItem
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    selectedItemIndex: MutableState<Int> = mutableIntStateOf(0)
) {

    val items = listOf(
        BottomNavBarItem.Home,
        BottomNavBarItem.Wallet,
        BottomNavBarItem.Track,
        BottomNavBarItem.Profile
    )

    val density = LocalDensity.current

    Surface(
        modifier = modifier
            .drawWithContent {
                val paddingPx = with(density) { 100.dp.toPx() }
                clipRect(
                    left = -paddingPx,
                    top = -paddingPx,
                    right = size.width + paddingPx,
                    bottom = size.height + paddingPx
                ) {
                    this@drawWithContent.drawContent()
                }
            },
        shape = RectangleShape,
        shadowElevation = 20.dp,
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            for (index in items.indices) {

                BottomNavNavItem(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            if (selectedItemIndex.value != items.indexOf(items[index])) {

                                selectedItemIndex.value = items.indexOf(items[index])
                            }
                        }
                        .width(45.dp)
                        .padding(
                            bottom = 9.dp
                        ),
                    bottomNavBarItem = items[index],
                    isSelected = selectedItemIndex.value == index
                )
            }
        }
    }
}

@Composable
fun BottomNavNavItem(
    modifier: Modifier = Modifier,
    bottomNavBarItem: BottomNavBarItem = BottomNavBarItem.Home,
    isSelected: Boolean = false
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
                .background(
                    color = if (isSelected) MainBlue else Color.Transparent
                )
        )

        Icon(
            modifier = Modifier
                .size(30.dp),
            imageVector = ImageVector.vectorResource(id = bottomNavBarItem.image),
            contentDescription = null,
            tint = if (isSelected) MainBlue else CustomGray
        )

        Text(
            text = bottomNavBarItem.title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = if (isSelected) MainBlue else CustomGray
        )
    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    BottomNavBar(
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun PreviewBottomNavBarItem() {
    BottomNavNavItem()
}