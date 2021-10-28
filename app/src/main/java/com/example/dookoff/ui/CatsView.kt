package com.example.dookoff.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.ui.theme.MainColor2
import com.example.dookoff.ui.theme.MainColor3

@Composable
fun CatsMajorView(stateOfCats: MutableState<List<CatBreedDomain>>) {

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
