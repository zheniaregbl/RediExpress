package ru.syndicate.rediexpress.ui.screens.otp_verify_screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.syndicate.rediexpress.ui.screens.otp_verify_screen.components.OTPPasswordView
import ru.syndicate.rediexpress.ui.theme.CustomGray
import ru.syndicate.rediexpress.ui.theme.MainBlue
import ru.syndicate.rediexpress.ui.theme.TextBlack

@SuppressLint("UnrememberedMutableState")
@Composable
fun OTPVerifyScreen(
    modifier: Modifier = Modifier,
    navigateToNewPassword: () -> Unit = { }
) {

    val context = LocalContext.current

    val scrollState = rememberScrollState()

    val isOtpTrue = remember {
        mutableStateOf(false)
    }

    val textList = listOf(
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        ),
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        ),
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        ),
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        ),
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        ),
        mutableStateOf(
            TextFieldValue(
                text = "",
                selection = TextRange(0)
            )
        )
    )
    val requesterList = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()
    )

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
                )
                .imePadding(),
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "OTP Verification",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = TextBlack
                )

                Text(
                    text = "Enter the 6 digit numbers sent to your email",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = CustomGray
                )
            }

            Spacer(
                modifier = Modifier
                    .height(70.dp)
            )

            OTPPasswordView(
                modifier = Modifier
                    .fillMaxWidth(),
                textList = textList,
                requesterList = requesterList,
                isOtpTrue = isOtpTrue
            )

            Spacer(
                modifier = Modifier
                    .height(12.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "If you didn’t receive code,",
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
                        text = "Resend"
                    ),
                    onClick = {  },
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
                    .height(84.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = MainBlue
                    )
                    .clickable {
                        if (isOtpTrue.value)
                            navigateToNewPassword()
                        else
                            Toast
                                .makeText(
                                    context,
                                    "Problem with OTP",
                                    Toast.LENGTH_LONG
                                )
                                .show()
                    }
                    .padding(
                        vertical = 15.dp
                    ),
                text = "Set new password",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun PreviewOTPVerifyScreen() {
    OTPVerifyScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}