package ru.syndicate.rediexpress.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.syndicate.rediexpress.ui.screens.auth_screen.AuthScreen
import ru.syndicate.rediexpress.ui.screens.forgot_password_screen.ForgotPasswordScreen
import ru.syndicate.rediexpress.ui.screens.home_screen.HomeScreen
import ru.syndicate.rediexpress.ui.screens.new_password_screen.NewPasswordScreen
import ru.syndicate.rediexpress.ui.screens.notification_screen.NotificationScreen
import ru.syndicate.rediexpress.ui.screens.register_screen.RegisterScreen
import ru.syndicate.rediexpress.ui.screens.onboarding_screen.OnboardingScreen
import ru.syndicate.rediexpress.ui.screens.otp_verify_screen.OTPVerifyScreen
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
                    navController.navigate(ScreenRoute.HomeScreen.route) {
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
                    .fillMaxSize(),
                navigateToSignIn = {
                    navController.navigate(ScreenRoute.AuthScreen.route) {
                        popUpTo(0)
                    }
                },
                navigateToSignUp = {
                    navController.navigate(ScreenRoute.RegisterScreen.route) {
                        popUpTo(0)
                    }
                }
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
                },
                navigateToOTP = {
                    navController.navigate(ScreenRoute.OTPVerifyScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.OTPVerifyScreen.route,
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

            OTPVerifyScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToNewPassword = {
                    navController.navigate(ScreenRoute.NewPasswordScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.NewPasswordScreen.route,
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

            NewPasswordScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = ScreenRoute.HomeScreen.route,
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

            HomeScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToNotification = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.NotificationScreen.route) {
                        navController.navigate(ScreenRoute.NotificationScreen.route)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.NotificationScreen.route,
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

            NotificationScreen(
                modifier = Modifier
                    .fillMaxSize(),
                onClickBack = {
                    navController.navigate(ScreenRoute.HomeScreen.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}