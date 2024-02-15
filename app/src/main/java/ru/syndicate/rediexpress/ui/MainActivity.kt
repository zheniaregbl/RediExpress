package ru.syndicate.rediexpress.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.logo.Alignment
import com.yandex.mapkit.logo.HorizontalAlignment
import com.yandex.mapkit.logo.VerticalAlignment
import com.yandex.mapkit.mapview.MapView
import dagger.hilt.android.AndroidEntryPoint
import ru.syndicate.rediexpress.BuildConfig
import ru.syndicate.rediexpress.navigation.AppNavigation
import ru.syndicate.rediexpress.ui.utils.LockScreenOrientation
import ru.syndicate.rediexpress.ui.theme.RediExpressTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private var init = false
        private var apiKey = BuildConfig.MAPKIT_API_KEY
    }

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("checkApiKey", apiKey)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        if (!init) {
            MapKitFactory.setApiKey(apiKey)
            MapKitFactory.initialize(this)
            init = true
        }

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val style = "[" +
                "        {" +
                "            \"types\": \"polyline\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"road\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e9e9e9\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polyline\"," +
                "            \"elements\": \"geometry.outline\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"road\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"9f9f9f\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"land\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e4e4e4\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"landcover\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e0e3e7\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"residential\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e9ecf0\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"industrial\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"f6e7d6\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"cemetery\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"c8cbce\"" +
                "            }" +
                "        }," +
                "        {" +
                "            \"types\": \"polygon\"," +
                "            \"elements\": \"geometry.fill\"," +
                "            \"tags\": {" +
                "                \"all\": [" +
                "                    \"park\"" +
                "                ]" +
                "            }," +
                "            \"stylers\": {" +
                "                \"color\": \"e0e3e7\"" +
                "            }" +
                "        }" +
                "    ]"

        mapView = MapView(this)

        mapView.mapWindow.map.setMapStyle(style)

        setContent {

            RediExpressTheme {

                val navController = rememberNavController()

                LockScreenOrientation(
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                )

                AppNavigation(
                    navController = navController,
                    mapView = mapView
                )
            }
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}