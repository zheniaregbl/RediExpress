package ru.syndicate.rediexpress.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yandex.mapkit.mapview.MapView
import ru.syndicate.rediexpress.ui.bottom_nav_bar.BottomNavBar
import ru.syndicate.rediexpress.view_model.send_package_view_model.SendPackageViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    mapView: MapView
) {

    val sendPackageViewModel = hiltViewModel<SendPackageViewModel>()

    val routeList = listOf(
        ScreenRoute.HomeScreen.route,
        ScreenRoute.WalletScreen.route,
        ScreenRoute.TrackScreen.route,
        ScreenRoute.ProfileScreen.route
    )

    val showNavigationMenu = navController
        .currentBackStackEntryAsState().value?.destination?.route in routeList.map { it }

    val selectedItemIndex = remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {

            if (showNavigationMenu)
                BottomNavBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding(),
                    navController = navController,
                    selectedItemIndex = selectedItemIndex
                )
        },
        contentWindowInsets = WindowInsets.systemBars
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = Color.White
        ) {

            AppNavGraph(
                navController = navController,
                sendPackageViewModel = sendPackageViewModel,
                mapView = mapView,
                routeList = routeList,
                navigateTo = {

                    selectedItemIndex.intValue = routeList.indexOf(it)

                    navController.navigate(it) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}