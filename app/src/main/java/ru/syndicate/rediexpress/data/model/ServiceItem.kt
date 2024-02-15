package ru.syndicate.rediexpress.data.model

import androidx.compose.runtime.Stable

@Stable
data class ServiceItem(
    val image: Int,
    val title: String,
    val description: String,
    val route: String
)
