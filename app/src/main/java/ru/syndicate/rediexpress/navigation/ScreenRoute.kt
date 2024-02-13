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
    data object NotificationScreen: ScreenRoute("notification_screen")
}