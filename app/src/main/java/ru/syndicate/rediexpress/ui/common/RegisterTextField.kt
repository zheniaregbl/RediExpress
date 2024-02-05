package ru.syndicate.rediexpress.ui.common

import androidx.compose.foundation.border
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.theme.TextHint

@Composable
fun RegisterTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    hintText: String = "",
    onValueChange: (String) -> Unit = { },
    isPassword: Boolean = false,
    isPhone: Boolean = false,
    isEmail: Boolean = false
) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = MainBlue,
        backgroundColor = MainBlue
    )
    var visible by remember {
        mutableStateOf(true)
    }

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
        visualTransformation = if (visible) VisualTransformation.None
            else PasswordVisualTransformation(
                mask = '*'
            ),
        cursorBrush = SolidColor(MainBlue),
        keyboardOptions = KeyboardOptions(
            keyboardType = when {
                isPhone -> KeyboardType.Number
                isEmail -> KeyboardType.Email
                else -> KeyboardType.Password
            }
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
                            end = if (isPassword) 6.dp else 0.dp
                        )
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

            if (isPassword)
                IconButton(
                    modifier = Modifier
                        .size(20.dp),
                    onClick = { visible = !visible }
                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(
                            id = if (visible) R.drawable.svg_password_hide
                                else R.drawable.svg_password_show
                        ),
                        contentDescription = null,
                        tint = TextBlack
                    )
                }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewRegisterTextField() {
    RegisterTextField(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = CustomGray,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(
                horizontal = 10.dp,
                vertical = 14.dp
            ),
        value = "Lens",
        hintText = "Name"
    )
}