package ru.syndicate.rediexpress

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import ru.syndicate.rediexpress.navigation.AppNavigation
import ru.syndicate.rediexpress.ui.utils.LockScreenOrientation
import ru.syndicate.rediexpress.ui.theme.RediExpressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            WindowCompat.setDecorFitsSystemWindows(window, false)

            RediExpressTheme {

                LockScreenOrientation(
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                )

                AppNavigation()
            }
        }
    }
}