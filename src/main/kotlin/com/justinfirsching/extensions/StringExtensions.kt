package com.justinfirsching.extensions

fun String.isNumber(): Boolean =
    when(this.toBigDecimalOrNull()) {
        null -> false
        else -> true
    }
