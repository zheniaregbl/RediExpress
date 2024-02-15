package ru.syndicate.rediexpress.data.model

import ru.syndicate.rediexpress.R

data class RiderItem(
    val name: String = "",
    val surname: String = "",
    val number: String = "",
    val stars: Int = 1,
    val carModel: String = "",
    val gender: String = "M",
    val image: Int = R.drawable.rider11
)
