package ru.syndicate.rediexpress.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yandex.mapkit.mapview.MapView
import ru.syndicate.rediexpress.data.model.RiderItem
import ru.syndicate.rediexpress.extensions.canGoBack
import ru.syndicate.rediexpress.ui.screens.add_payment_method_screen.AddPaymentMethodScreen
import ru.syndicate.rediexpress.ui.screens.auth_screen.AuthScreen
import ru.syndicate.rediexpress.ui.screens.book_rider_screen.BookRiderScreen
import ru.syndicate.rediexpress.ui.screens.forgot_password_screen.ForgotPasswordScreen
import ru.syndicate.rediexpress.ui.screens.home_screen.HomeScreen
import ru.syndicate.rediexpress.ui.screens.new_password_screen.NewPasswordScreen
import ru.syndicate.rediexpress.ui.screens.notification_screen.NotificationScreen
import ru.syndicate.rediexpress.ui.screens.register_screen.RegisterScreen
import ru.syndicate.rediexpress.ui.screens.onboarding_screen.OnboardingScreen
import ru.syndicate.rediexpress.ui.screens.operation_screen.OperationScreen
import ru.syndicate.rediexpress.ui.screens.otp_verify_screen.OTPVerifyScreen
import ru.syndicate.rediexpress.ui.screens.package_info_screen.PackageInfoScreen
import ru.syndicate.rediexpress.ui.screens.profile_screen.ProfileScreen
import ru.syndicate.rediexpress.ui.screens.rider_profile_screen.RiderProfileScreen
import ru.syndicate.rediexpress.ui.screens.send_package_screen.SendPackageScreen
import ru.syndicate.rediexpress.ui.screens.splash_screen.SplashScreen
import ru.syndicate.rediexpress.ui.screens.track_screen.TrackScreen
import ru.syndicate.rediexpress.ui.screens.wallet_screen.WalletScreen
import ru.syndicate.rediexpress.view_model.send_package_view_model.SendPackageEvent
import ru.syndicate.rediexpress.view_model.send_package_view_model.SendPackageViewModel

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavGraph(
    navController: NavHostController,
    sendPackageViewModel: SendPackageViewModel,
    mapView: MapView,
    routeList: List<String>,
    navigateTo: (String) -> Unit
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
                },
                navigateToService = { route ->
                    if (navController.currentBackStackEntry?.destination?.route != route) {

                        if (route in routeList) navigateTo(route) else navController.navigate(route)
                    }
                }
            )
        }

        composable(
            route = ScreenRoute.WalletScreen.route,
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

            WalletScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = ScreenRoute.TrackScreen.route,
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

            TrackScreen(
                modifier = Modifier
                    .fillMaxSize(),
                mapView = mapView,
                navigateToInfo = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.PackageInfoAcceptScreen.route)
                        navController.navigate(ScreenRoute.PackageInfoAcceptScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.ProfileScreen.route,
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

            ProfileScreen(
                modifier = Modifier
                    .fillMaxSize()
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
                    if (navController.canGoBack)
                        navController.popBackStack()
                }
            )
        }

        composable(
            route = ScreenRoute.EnterPackageInfoScreen.route,
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

            SendPackageScreen(
                modifier = Modifier
                    .fillMaxSize(),
                addressOriginText = sendPackageViewModel.addressOriginText.collectAsState().value,
                addressDestinationText = sendPackageViewModel.addressDestinationText.collectAsState().value,
                stateCountryOriginText = sendPackageViewModel.stateCountryOriginText.collectAsState().value,
                stateCountryDestinationText = sendPackageViewModel.stateCountryDestinationText.collectAsState().value,
                phoneNumberOriginText = sendPackageViewModel.phoneNumberOriginText.collectAsState().value,
                phoneNumberDestinationText = sendPackageViewModel.phoneNumberDestinationText.collectAsState().value,
                otherOriginText = sendPackageViewModel.otherOriginText.collectAsState().value,
                otherDestinationText = sendPackageViewModel.otherDestinationText.collectAsState().value,
                itemsPackageText = sendPackageViewModel.itemsPackageText.collectAsState().value,
                weightText = sendPackageViewModel.weightText.collectAsState().value,
                worthText = sendPackageViewModel.worthText.collectAsState().value,
                deliveryType = sendPackageViewModel.deliveryType.collectAsState().value,
                changeAddressOrigin = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeAddressOrigin(it))
                },
                changeAddressDestination = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeAddressDestination(it))
                },
                changeStateCountryOrigin = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeStateCountryOrigin(it))
                },
                changeStateCountryDestination = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeStateCountryDestination(it))
                },
                changePhoneNumberOrigin = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changePhoneNumberOrigin(it))
                },
                changePhoneNumberDestination = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changePhoneNumberDestination(it))
                },
                changeOthersOrigin = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeOthersOrigin(it))
                },
                changeOthersDestination = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeOthersDestination(it))
                },
                changeItems = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeItems(it))
                },
                changeWeight = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeWeight(it))
                },
                changeWorth = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeWorth(it))
                },
                changeDeliveryType = {
                    sendPackageViewModel.onEvent(SendPackageEvent.changeDeliveryType(it))
                },
                onClickBack = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                },
                onClickNext = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.ShowPackageInfoScreen.route)
                        navController.navigate(ScreenRoute.ShowPackageInfoScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.ShowPackageInfoScreen.route,
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

            PackageInfoScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToEdit = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                },
                onClickToMakePayment = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.AddPaymentMethodScreen.route)
                        navController.navigate(ScreenRoute.AddPaymentMethodScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.PackageInfoAcceptScreen.route,
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

            PackageInfoScreen(
                modifier = Modifier
                    .fillMaxSize(),
                isDelivered = true,
                onClickBack = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                },
                navigateToAccept = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.HomeScreen.route)
                        navigateTo(ScreenRoute.HomeScreen.route)
                }
            )
        }

        composable(
            route = ScreenRoute.BookRiderScreen.route,
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

            BookRiderScreen(
                modifier = Modifier
                    .fillMaxSize(),
                navigateToRider = { rider ->

                    val moshi = Moshi
                        .Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()

                    val jsonAdapter = moshi.adapter(RiderItem::class.java).lenient()

                    val riderJson = jsonAdapter.toJson(rider)

                    navController.navigate(
                        ScreenRoute.RiderProfileScreen.route.replace("{rider}", riderJson)
                    )
                },
                onClickBack = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                }
            )
        }

        composable(
            route = ScreenRoute.RiderProfileScreen.route,
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
        ) { backStackEntry ->

            val riderJson = backStackEntry.arguments?.getString("rider")

            val moshi = Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val jsonAdapter = moshi.adapter(RiderItem::class.java).lenient()

            val riderObject = riderJson?.let { jsonAdapter.fromJson(it) }


            RiderProfileScreen(
                modifier = Modifier
                    .fillMaxSize(),
                mapView = mapView,
                rider = riderObject!!,
                onClickBack = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                }
            )
        }

        composable(
            route = ScreenRoute.AddPaymentMethodScreen.route,
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

            AddPaymentMethodScreen(
                modifier = Modifier
                    .fillMaxSize(),
                onClickBack = {
                    if (navController.canGoBack)
                        navController.popBackStack()
                },
                navigateToNext = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.TransactionOperationScreen.route)
                        navController.navigate(ScreenRoute.TransactionOperationScreen.route) {
                            popUpTo(0)
                        }
                }
            )
        }

        composable(
            route = ScreenRoute.TransactionOperationScreen.route,
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

            OperationScreen(
                modifier = Modifier
                    .fillMaxSize(),
                isDelivery = false,
                navigateToTrackItem = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.TrackScreen.route)
                        navigateTo(ScreenRoute.TrackScreen.route)
                },
                navigateToHome = {
                    if (navController.currentBackStackEntry?.destination?.route != ScreenRoute.HomeScreen.route)
                        navController.navigate(ScreenRoute.HomeScreen.route) {
                            popUpTo(0)
                        }
                }
            )
        }
    }
}