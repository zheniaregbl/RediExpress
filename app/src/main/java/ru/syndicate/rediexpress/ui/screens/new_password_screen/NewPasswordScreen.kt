package ru.syndicate.rediexpress.ui.screens.new_password_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NewPasswordScreen(
    modifier: Modifier = Modifier,
    onLogIn: () -> Unit = { }
) {

    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var newPasswordText by remember {
        mutableStateOf("")
    }
    var confirmPasswordText by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

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
                    text = "New Password",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    color = TextBlack
                )

                Text(
                    text = "Enter new password",
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
                    text = "New password",
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
                    value = newPasswordText,
                    hintText = "New password",
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            newPasswordText = it
                    },
                    isPassword = true
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
                    text = "Confirm password",
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
                    value = confirmPasswordText,
                    hintText = "Confirm password",
                    onValueChange = {
                        if (!it.containsUnwantedChar())
                            confirmPasswordText = it
                    },
                    isPassword = true
                )
            }

            Spacer(
                modifier = Modifier
                    .height(92.dp)
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        color = MainBlue
                    )
                    .clickable {

                        keyboardController?.hide()

                        if (newPasswordText == confirmPasswordText && newPasswordText.isNotEmpty())
                            onLogIn()
                        else {
                            Toast
                                .makeText(
                                    context,
                                    "Problem with password",
                                    Toast.LENGTH_LONG
                                )
                                .show()

                        }
                    }
                    .padding(
                        vertical = 15.dp
                    ),
                text = "Log in",
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
fun PreviewNewPasswordScreen() {
    NewPasswordScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    )
}