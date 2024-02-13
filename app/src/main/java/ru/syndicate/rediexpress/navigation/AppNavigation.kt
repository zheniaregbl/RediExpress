package ru.syndicate.rediexpress.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.syndicate.rediexpress.ui.bottom_nav_bar.BottomNavBar

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    val routeList = listOf(
        ScreenRoute.HomeScreen.route
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    BottomNavBar(
                        modifier = Modifier
                            .fillMaxWidth(),
                        selectedItemIndex = selectedItemIndex
                    )

                    Spacer(
                        modifier = Modifier
                            .navigationBarsPadding()
                    )
                }
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
                navController = navController
            )
        }
    }
}