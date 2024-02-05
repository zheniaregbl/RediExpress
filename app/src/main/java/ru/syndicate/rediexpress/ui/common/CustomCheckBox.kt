package ru.syndicate.rediexpress.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.MainBlue

@Composable
fun CustomCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    activeColor: Color = MainBlue
) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        if (checked)
            Icon(
                modifier = Modifier
                    .size(10.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.svg_check),
                contentDescription = null,
                tint = Color.White
            )
    }
}

@Preview
@Composable
fun PreviewCustomCheckBox() {
    CustomCheckBox(
        modifier = Modifier
            .clip(RoundedCornerShape(2.dp))
            .size(14.dp)
            .background(
                color = MainBlue
            )
            .border(
                width = 1.dp,
                color = MainBlue,
                shape = RoundedCornerShape(2.dp)
            ),
        checked = true
    )
}