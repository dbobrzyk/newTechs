package com.example.dookoff.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.dookoff.R
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.ui.theme.BackgroundColor
import com.example.dookoff.ui.theme.ColorGrey
import com.example.dookoff.ui.theme.MainColor3

const val DAYS_OFF = 0
const val CATS = 1
const val RESERVE_TABLE = 2


@Composable
fun HomeView(stateOfCats: MutableState<List<CatBreedDomain>>, context: Context) {
    var pageSelected by remember {
        mutableStateOf(2)
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
                else if (pageSelected == CATS)
                    CatsMajorView(stateOfCats)
                else if (pageSelected == RESERVE_TABLE)
                    ReservationMajorView(context)
            }

        }
    )
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
                .testTag("bottom0")
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
                .testTag("bottom1")
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
        Column(
            modifier = Modifier
                .weight(1f)
                .testTag("bottom2")
                .clickable {
                    selectPage.invoke(2)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BottomButton(
                2,
                com.example.dookoff.R.drawable.ic_summer,
                stringResource(R.string.reserve_table),
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

