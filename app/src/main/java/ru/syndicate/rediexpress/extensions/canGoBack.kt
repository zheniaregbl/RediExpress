package ru.syndicate.rediexpress.extensions

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED