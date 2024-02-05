package ru.syndicate.rediexpress.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.syndicate.rediexpress.ui.screens.auth_screen.AuthScreen
import ru.syndicate.rediexpress.ui.screens.forgot_password_screen.ForgotPasswordScreen
import ru.syndicate.rediexpress.ui.screens.register_screen.RegisterScreen
import ru.syndicate.rediexpress.ui.screens.onboarding_screen.OnboardingScreen
import ru.syndicate.rediexpress.ui.screens.splash_screen.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoute.SplashScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {

        composable(
            route = ScreenRoute.SplashScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            SplashScreen(
                modifier = Modifier
                    .fillMaxSize(),
                onLaunchEnd = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.OnboardingScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            OnboardingScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = ScreenRoute.RegisterScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            RegisterScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToLogIn = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.AuthScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            AuthScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToSignUp = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(0)
                    }
                },
                navigateToForgotPassword = {
                    navController.navigate(ScreenRoute.ForgotPasswordScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.ForgotPasswordScreen.route,
            enterTransition = {
                fadeIn(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            },
            exitTransition = {
                fadeOut(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease
                    )
                )
            }
        ) {

            ForgotPasswordScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToBack = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}