package ru.syndicate.rediexpress.ui.screens.send_package_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.extensions.advancedShadow
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint

@Composable
fun PackageTextField(
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
        modifier = modifier,
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
            modifier = Modifier
                .background(
                    color = Color.White
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CompositionLocalProvider(
                LocalTextSelectionColors provides customTextSelectionColors
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    if (value.isEmpty()) {

                        Text(
                            text = hintText,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            color = TextHint
                        )
                    }

                    innerTextField()
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewPackageTextField() {

    PackageTextField(
        modifier = Modifier
            .advancedShadow(
                color = Color.Black,
                alpha = 0.3f,
                shadowBlurRadius = 10.dp,
                offsetY = 15.dp
            )
            .padding(
                top = 10.dp,
                bottom = 10.dp
            )
            .clip(RectangleShape)
            .fillMaxWidth(),
        value = "Text"
    )
}