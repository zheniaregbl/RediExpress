package ru.syndicate.rediexpress.ui.common

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.ui.theme.MainBlue

@Composable
fun BalanceText(
    value: Double = 2000.0,
    isVisible: Boolean = true
) {

    BasicTextField(
        value = "N$value",
        onValueChange = { },
        textStyle = TextStyle(
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = MainBlue
        ),
        readOnly = true,
        visualTransformation = if (isVisible) VisualTransformation.None
        else PasswordVisualTransformation(
            mask = '*'
        )
    ) { innerTextField ->

        innerTextField()
    }
}

@Preview
@Composable
fun PreviewBalanceText() {
    BalanceText(
        value = 2000.0
    )
}