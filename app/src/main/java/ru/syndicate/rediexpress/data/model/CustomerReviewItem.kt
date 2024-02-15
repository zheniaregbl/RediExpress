package ru.syndicate.rediexpress.data.model

data class CustomerReviewItem(
    val name: String,
    val surname: String,
    val comment: String,
    val stars: Int,
    val image: Int
)
