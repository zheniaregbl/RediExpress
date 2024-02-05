package ru.syndicate.rediexpress.ui.screens.register_screen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.extensions.containsUnwantedChar
import ru.syndicate.rediexpress.ui.common.CustomCheckBox
import ru.syndicate.rediexpress.ui.common.RegisterTextField
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.CustomYellow
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack
import ru.syndicate.rediexpress.ui.utils.rememberImeState

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToLogIn: () -> Unit = { }
) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    var fullNameText by remember {
        mutableStateOf("")
    }
    var phoneText by remember {
        mutableStateOf("")
    }
    var emailText by remember {
        mutableStateOf("")
    }
    var passwordText by remember {
        mutableStateOf("")
    }

    var checkAgreePolicy by remember {
        mutableStateOf(false)
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
                    text = "Create an account",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = TextBlack
                )

                Text(
                    text = "Complete the sign up process to get started",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomGray
                )
            }

            Spacer(
                modifier = Modifier
                    .height(38.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Full name",
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
                    value = fullNameText,
                    hintText = "Full name",
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            fullNameText = it
                    }
                )
            }

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Phone number",
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
                    value = phoneText,
                    hintText = "Phone",
                    onValueChange = {
                        if (it.isDigitsOnly())
                            phoneText = it
                    },
                    isPhone = true
                )
            }

            Spacer(
                modifier = Modifier
                    .height(24.dp)
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
                    .height(24.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Password",
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
                    value = passwordText,
                    hintText = "Password",
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            passwordText = it
                    },
                    isPassword = true
                )
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                CustomCheckBox(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .size(20.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            checkAgreePolicy = !checkAgreePolicy
                        }
                        .background(
                            color = if (checkAgreePolicy) MainBlue else Color.Transparent
                        )
                        .border(
                            width = 1.dp,
                            color = MainBlue,
                            shape = RoundedCornerShape(2.dp)
                        ),
                    checked = checkAgreePolicy
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 26.dp
                        )
                ) {

                    Text(
                        text = buildAnnotatedString {

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                    color = CustomGray
                                )
                            ) {
                                append("By ticking this box, you agree to our ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                    color = CustomYellow
                                )
                            ) {
                                append("Terms and conditions and private policy")
                            }
                        },
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .height(46.dp)
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
                text = "Sign Up",
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

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Already have an account?",
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
                        onClick = { navigateToLogIn() },
                        style = TextStyle(
                            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = MainBlue
                        )
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )

                Text(
                    text = "or sign up using",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    color = CustomGray
                )

                Spacer(
                    modifier = Modifier
                        .height(8.dp)
                )

                Image(
                    modifier = Modifier
                        .padding(
                            bottom = 36.dp
                        )
                        .size(20.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_google),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    RegisterScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}