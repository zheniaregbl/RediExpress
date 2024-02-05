package ru.syndicate.rediexpress.ui.screens.forgot_password_screen

import androidx.compose.animation.core.tween
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.extensions.containsUnwantedChar
import ru.syndicate.rediexpress.ui.common.RegisterTextField
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.utils.rememberImeState

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navigateToOTP: () -> Unit = { },
    navigateToBack: () -> Unit = { }
) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    var emailText by remember {
        mutableStateOf("")
    }

    LaunchedEffect(imeState.value) {
        if (imeState.value)
            scrollState.animateScrollTo(scrollState.maxValue, tween(200))
    }

    Box(
        modifier = modifier
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 24.dp
                )
                .verticalScroll(
                    scrollState
                ),
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier
                    .padding(
                        top = 36.dp
                    )
            ) {

                Text(
                    text = "Forgot Password",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = TextBlack
                )

                Text(
                    text = "Enter your email address",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomGray
                )
            }

            Spacer(
                modifier = Modifier
                    .height(48.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "E-mail address",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomGray
                )

                RegisterTextField(
                    modifier = Modifier
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
                    value = emailText,
                    hintText = "E-mail",
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            emailText = it
                    },
                    isEmail = true
                )
            }

            Spacer(
                modifier = Modifier
                    .height(64.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = MainBlue
                    )
                    .clickable {

                    }
                    .padding(
                        vertical = 15.dp
                    ),
                text = "Send OTP",
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 36.dp
                    ),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Remember password? Back to",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = CustomGray
                )

                Spacer(
                    modifier = Modifier
                        .width(2.dp)
                )

                ClickableText(
                    text = AnnotatedString(
                        text = "Log in"
                    ),
                    onClick = { navigateToBack() },
                    style = TextStyle(
                        fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        color = MainBlue
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}