package com.example.dookoff.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dookoff.R
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.model.domain.DayOff
import com.example.dookoff.model.domain.DayOffApplication
import com.example.dookoff.ui.theme.BackgroundColor
import com.example.dookoff.ui.theme.ColorGrey
import com.example.dookoff.ui.theme.MainColor2
import com.example.dookoff.ui.theme.MainColor3
import com.example.dookoff.utils.toDateInString
import java.util.*

@Preview
@Composable
fun ComposablePreview() {
//    HomeView()
}

const val DAYS_OFF = 0
const val PAYCHECKS = 1

@Composable
fun HomeView(stateOfCats: MutableState<List<CatBreedDomain>>) {
    var pageSelected by remember {
        mutableStateOf(0)
    }
    Scaffold(
        bottomBar = { BottomBar(pageSelected) { page -> pageSelected = page } },
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize(),
        content = { innerPadding ->
            Box(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, innerPadding.calculateBottomPadding())
            ) {
                if (pageSelected == DAYS_OFF)
                    OffDaysMajorView()
                else
                    PaycheckMajorView(stateOfCats)
            }

        }
    )
}

@Composable
fun PaycheckMajorView(stateOfCats: MutableState<List<CatBreedDomain>>) {
//    val months = listOf<String>(
//        "Styczen",
//        "Luty",
//        "Marzec",
//        "Kwiecien",
//        "Maj",
//        "Czerwiec",
//        "lipiec",
//        "Sierpień",
//        "Wrzesień",
//        "Listopad",
//        "Grudzień"
//    )

    Column {
        var countryChosen by remember {
            mutableStateOf("")
        }
        val catsCountries = stateOfCats.value.map { it.country }.distinct().toList()
        LazyRow(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            items(catsCountries.size) {
                CatCountryButton(catsCountries[it], countryChosen == catsCountries[it], {country -> if(countryChosen == country) countryChosen = "" else countryChosen = country })
            }
        }

        var catsList = stateOfCats.value
        if(countryChosen.isNotEmpty())
            catsList = catsList.filter { it.country == countryChosen }
        LazyColumn(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            items(catsList.size) {
                Column(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MainColor3)
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        catsList[it].breed,
                        color = Color.White,
                        style = MaterialTheme.typography.h6
                    )
                    CatInfoTextView("Pochodzenie", catsList[it].origin)
                    CatInfoTextView("Państwo", catsList[it].country)
                    CatInfoTextView("Sierść", catsList[it].coat)
                    CatInfoTextView("Wzór", catsList[it].pattern)
                }
            }
        }
    }
}

@Composable
fun CatCountryButton(country: String, enabled: Boolean, countryChosen: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = if (enabled) MainColor2 else MainColor3)
            .padding(top = 8.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
            .clickable {
                countryChosen.invoke(country)
            }
    ) {
        Text(country, color = Color.White)
    }
}

@Composable
fun CatInfoTextView(label: String, info: String) {
    if (info.isNotEmpty()) {
        Row {
            Text("${label}: ", color = Color.White, fontWeight = FontWeight.Bold)
            Text(info, color = Color.White)
        }
    }
}


@Composable
fun OffDaysMajorView() {
    Column(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .verticalScroll(rememberScrollState())

    ) {
        GreetingsView()
        Header(headerText = stringResource(R.string.off_coming))
        DaysOffToComeSection(daysOffList = testDayOffList)
        Header(headerText = stringResource(R.string.history_of_offs))
        DaysOffToComeSection(daysOffList = historicalTestDayOffList)
        Header(headerText = stringResource(R.string.off_applications_list))
        DayOffApplicationsList(list = testApplicationList)

    }
}

@Composable
fun BottomBar(pageSelected: Int, selectPage: (Int) -> Unit) {

    Row(
        modifier = Modifier
            .background(MainColor3)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    selectPage.invoke(0)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BottomButton(
                0,
                com.example.dookoff.R.drawable.ic_document,
                stringResource(R.string.day_offs),
                pageSelected
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    selectPage.invoke(1)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BottomButton(
                1,
                com.example.dookoff.R.drawable.ic_money,
                stringResource(R.string.paychecks),
                pageSelected
            )
        }
    }
}

@Composable
fun BottomButton(
    index: Int,
    drawableId: Int,
    buttonName: String,
    pageSelected: Int
) {

    Icon(
        painter = painterResource(
            id = drawableId
        ),
        contentDescription = "document",
        modifier = Modifier
            .padding(top = 8.dp)
            .size(width = 30.dp, height = 30.dp),
        tint =
        if (index == pageSelected)
            Color.White
        else
            ColorGrey,
    )
    Text(
        text = buttonName,
        style = MaterialTheme.typography.body2,
        color =
        if (index == pageSelected)
            Color.White
        else
            ColorGrey,
        modifier = Modifier.padding(bottom = 8.dp)
    )

}

@Composable
fun GreetingsView(name: String = "User") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(color = MainColor2)
            .padding(16.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.good_morning) + name + "!",
                style = MaterialTheme.typography.h5,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.off_test_3),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.off_test_2),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
            Text(
                text = stringResource(R.string.off_test_1),
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "o",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
        }
    }
}

@Composable
fun Header(headerText: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp, end = 0.dp, top = 16.dp, bottom = 0.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$headerText",
                style = MaterialTheme.typography.body1,
                color = Color.Black
            )
        }
    }
}

@Composable
fun DaysOffToComeSection(daysOffList: List<DayOff>) {
    LazyRow {
        items(daysOffList.size) {
            Box(
                modifier = Modifier
                    .padding(end = 16.dp, top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MainColor2)
                    .padding(16.dp)


            ) {
                Column {
                    if (!daysOffList[it].isHistorical)
                        Row {
                            Column {

                                Text(
                                    text =
                                    if (daysOffList[it].isInProgress)
                                        "Twój urlop właśnie trwa!"
                                    else
                                        "Twój urlop rozpocznie się za 24 dni",
                                    color = Color.White,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                            }
                        }
                    Row {
                        Column {
                            Text(
                                text = "Długość urlopu: ${daysOffList[it].timeInDays} dni",
                                color = Color.White
                            )
                            Text(
                                text = "Start: ${daysOffList[it].dateStart.toDateInString()}",
                                color = Color.White
                            )
                            Text(
                                text = "Koniec: ${daysOffList[it].dateEnd.toDateInString()}",
                                color = Color.White
                            )
                        }
                        Column {
                            Icon(
                                painter = painterResource(
                                    id =
                                    if (daysOffList[it].isHistorical)
                                        com.example.dookoff.R.drawable.ic_historical
                                    else
                                        com.example.dookoff.R.drawable.ic_summer
                                ),
                                contentDescription = "summer",
                                modifier = Modifier
                                    .size(width = 60.dp, height = 60.dp)
                                    .padding(start = 16.dp),
                                tint = Color.White
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(color = MainColor3)
                                .align(Alignment.CenterVertically)
                                .padding(top = 8.dp, bottom = 8.dp, start = 24.dp, end = 24.dp)
                        ) {
                            Text("Szczegóły", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DayOffApplicationsList(list: List<DayOffApplication>) {
    Column {
        list.forEach { application ->
            Box(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = MainColor2)
                    .padding(16.dp)
                    .fillMaxWidth()

            ) {
                Column {
                    Text(
                        text = application.title,
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    if (application.subtitle?.isNotEmpty() == true) {
                        Text(
                            text = application.subtitle,
                            style = MaterialTheme.typography.body2,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

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
        dateStart = Date(),
        dateEnd = Date(),
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

