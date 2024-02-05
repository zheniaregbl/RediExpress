package ru.syndicate.rediexpress.ui.screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import ru.syndicate.rediexpress.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onLaunchEnd: () -> Unit = { }
) {

    LaunchedEffect(Unit) {
        delay(700)
        onLaunchEnd()
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.svg_redi_logo),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(
        modifier = Modifier
            .fillMaxSize()
    )
}