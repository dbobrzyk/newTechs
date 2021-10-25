package com.example.dookoff.model

import java.util.*

data class DayOff(
    val dateStart: Date,
    val dateEnd: Date,
    val timeInDays: Int,
    val isHistorical: Boolean = false,
    val isInProgress: Boolean = false
)