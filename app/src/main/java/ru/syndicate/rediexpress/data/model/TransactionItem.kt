package ru.syndicate.rediexpress.data.model

import java.time.LocalDate

data class TransactionItem(
    val text: String = "Top up",
    val date: LocalDate = LocalDate.of(2024, 1, 13),
    val value: Double = 2000.0
)
