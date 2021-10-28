package com.example.dookoff.ui

import com.example.dookoff.model.domain.DayOff
import com.example.dookoff.model.domain.DayOffApplication
import java.util.*

//Test lists just to mock the data
val testDayOffList = listOf(
    DayOff(
        dateStart = Date(),
        dateEnd = Date(),
        isHistorical = false,
        isInProgress = true,
        timeInDays = 7
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(),
        isHistorical = false,
        isInProgress = false,
        timeInDays = 1
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(),
        isHistorical = false,
        isInProgress = false,
        timeInDays = 14
    )
)

val historicalTestDayOffList = listOf(
    DayOff(
        dateStart = Date(Date().time-65276483),
        dateEnd = Date(Date().time+4756837),
        isHistorical = true,
        isInProgress = true,
        timeInDays = 7
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(),
        isHistorical = true,
        isInProgress = false,
        timeInDays = 1
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(Date().time+457635),
        isHistorical = true,
        isInProgress = true,
        timeInDays = 15
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(),
        isHistorical = true,
        isInProgress = false,
        timeInDays = 2
    ),
)

val testApplicationList = listOf(
    DayOffApplication("Urlop wypoczynkowy", null),
    DayOffApplication("Urlop wypoczynkowy na żądanie", null),
    DayOffApplication("Dzień wolny za święto", null),
    DayOffApplication("Urlop na dziecko", "Na cały dzień"),
    DayOffApplication("Urlop na dziecko", "Na część dnia"),
    DayOffApplication("Urlop okolicznościowy", null),
    DayOffApplication("Urlop bezpłatny", null)

)
