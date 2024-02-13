package ru.syndicate.rediexpress.data.model

import ru.syndicate.rediexpress.R
import ru.syndicate.rediexpress.navigation.ScreenRoute

sealed class BottomNavBarItem(
    val image: Int,
    val title: String,
    val route: String
) {
    data object Home: BottomNavBarItem(
        image = R.drawable.svg_nav_home,
        title = "Home",
        route = ScreenRoute.HomeScreen.route
    )

    data object Wallet: BottomNavBarItem(
        image = R.drawable.svg_nav_wallet,
        title = "Wallet",
        route = ScreenRoute.HomeScreen.route
    )

    data object Track: BottomNavBarItem(
        image = R.drawable.svg_nav_car,
        title = "Track",
        route = ScreenRoute.HomeScreen.route
    )

    data object Profile: BottomNavBarItem(
        image = R.drawable.svg_nav_profile,
        title = "Profile",
        route = ScreenRoute.HomeScreen.route
    )
}