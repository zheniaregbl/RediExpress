package ru.syndicate.rediexpress.ui.screens.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint

@Composable
fun SearchLine(
    modifier: Modifier = Modifier,
    value: String = "",
    hintText: String = "",
    onValueChange: (String) -> Unit = { },
) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = MainBlue,
        backgroundColor = MainBlue
    )

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = TextBlack
        ),
        singleLine = true,
        cursorBrush = SolidColor(MainBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    ) { innerTextField ->

        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {

            CompositionLocalProvider(
                LocalTextSelectionColors provides customTextSelectionColors
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            end = 6.dp
                        )
                ) {
                    if (value.isEmpty()) {

                        Text(
                            text = hintText,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = CustomGray
                        )
                    }

                    innerTextField()
                }
            }

            Icon(
                modifier = Modifier
                    .size(14.dp),
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.svg_search
                ),
                contentDescription = null,
                tint = CustomGray
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchLine() {
    SearchLine(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .background(
                color = TextHint
            )
            .padding(
                horizontal = 12.dp,
                vertical = 9.dp
            ),
        value = "123"
    )
}