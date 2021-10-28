package com.example.dookoff.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dookoff.R
import com.example.dookoff.model.domain.DayOff
import com.example.dookoff.model.domain.DayOffApplication
import com.example.dookoff.ui.theme.MainColor2
import com.example.dookoff.ui.theme.MainColor3
import com.example.dookoff.utils.toDateInString

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
                                        R.drawable.ic_historical
                                    else
                                        R.drawable.ic_summer
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