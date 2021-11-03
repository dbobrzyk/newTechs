package com.example.dookoff.ui

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dookoff.R
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.ui.theme.MainColor2
import com.example.dookoff.ui.theme.MainColor3
import java.util.*

@Composable
fun ReservationMajorView(context: Context) {

    var shouldShowDatePicker = remember { mutableStateOf(false)}

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.background_pizza
                ),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = "summer",
            )
        }


        Text(
            text = "Pod Zielonym Smokiem",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp, 32.dp, 16.dp, 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_localization
                    ),
                    contentDescription = "summer",
                    tint = MainColor3,
                    modifier = Modifier
                        .padding(end = 4.dp, top = 4.dp, bottom = 4.dp)
                        .size(width = 24.dp, height = 24.dp)
                )

                Text(
                    text = "Mroczna puszcza",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        shouldShowDatePicker.value = true
                    }
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_historical
                    ),
                    contentDescription = "summer",
                    tint = MainColor3,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(width = 24.dp, height = 24.dp)
                )

                Text(text = "10:00 - 21:00", modifier = Modifier.align(Alignment.CenterVertically))
            }

        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_money
                ),
                contentDescription = "summer",
                tint = MainColor3,
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(width = 24.dp, height = 24.dp)

            )

            Text(text = "Średnia ocen: 2.8", modifier = Modifier.align(Alignment.CenterVertically))

        }

        Text(
            modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp),
            text = "Znajdowała się w miejscowości Nad Wodą, przy Wielkim Gościńcu Wschodnim. Tawerna ta była najbliżej położoną gospodą od Hobbitonu. Znajdowała się jedną milę na południowy wschód od mostu na Wodzie."
        )
        Text(
            modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp),
            text = "Więcej informacji",
            fontWeight = FontWeight.Bold,
            color = MainColor3
        )

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(MainColor2)
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Przeklęty widok, który powinien zostać na górze ekranu podczas przewijania",
                    color = Color.White
                )
            }
        }

        TextMockedRows()

        if(shouldShowDatePicker.value){
            showDatePicker(context)
        }

    }
}

@Composable
fun showDatePicker(context: Context){

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/$month/$year"
        }, year, month, day
    )

    datePickerDialog.show()

}