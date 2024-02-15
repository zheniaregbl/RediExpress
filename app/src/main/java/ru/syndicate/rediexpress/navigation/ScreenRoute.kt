package ru.syndicate.rediexpress.navigation

sealed class ScreenRoute(val route: String) {

    data object SplashScreen: ScreenRoute("splash_screen")
    data object OnboardingScreen: ScreenRoute("onboarding_screen")
    data object RegisterScreen: ScreenRoute("register_screen")
    data object AuthScreen: ScreenRoute("auth_screen")
    data object ForgotPasswordScreen: ScreenRoute("forgot_password_screen")
    data object OTPVerifyScreen: ScreenRoute("otp_verify_screen")
    data object NewPasswordScreen: ScreenRoute("new_password_screen")
    data object HomeScreen: ScreenRoute("home_screen")
    data object WalletScreen: ScreenRoute("wallet_screen")
    data object TrackScreen: ScreenRoute("track_screen")
    data object ProfileScreen: ScreenRoute("profile_screen")
    data object NotificationScreen: ScreenRoute("notification_screen")
    data object EnterPackageInfoScreen: ScreenRoute("enter_package_info_screen")
    data object ShowPackageInfoScreen: ScreenRoute("show_package_info_screen")
    data object BookRiderScreen: ScreenRoute("book_rider_screen")
    data object RiderProfileScreen: ScreenRoute("rider_profile_screen?rider={rider}")
    data object AddPaymentMethodScreen: ScreenRoute("add_payment_method_screen")
    data object TransactionOperationScreen: ScreenRoute("transaction_operation_screen")
    data object PackageInfoAcceptScreen: ScreenRoute("package_info_accept_screen")
}