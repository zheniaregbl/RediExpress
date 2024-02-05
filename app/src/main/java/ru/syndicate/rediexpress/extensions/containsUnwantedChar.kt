package ru.syndicate.rediexpress.extensions

fun String.containsUnwantedChar(): Boolean =
    contains(' ') || contains('/') || contains('\\') || contains('\"') ||
            contains('\'')