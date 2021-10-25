package com.example.dookoff.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Pattern: HH:mm:ss
 */
fun Date.toDateInString(): String{
    val sdf= SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    return sdf.format(this)
}