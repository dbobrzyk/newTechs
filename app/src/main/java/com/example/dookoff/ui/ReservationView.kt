package com.example.dookoff.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun ReservationMajorView() {

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



        Column(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp, 50.dp, 16.dp, 50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Podczas Wojny o Pierścień karczma, podobnie jak wiele innych zakątków Shire'u, została zdewastowana przez ludzi Sarumana. Gdy Frodo, Merry, Pippin i Sam wracali do Shire, w Nad Wodą gospodę Pod Zielonym Smokiem zastali w katastrofalnym stanie. Sama karczma była zamknięta, okna zostały wybite[2].")
            }

            Box(
                modifier = Modifier
                    .padding(16.dp, 50.dp, 16.dp, 50.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Karczma Pod Zielonym Smokiem była często odwiedzana przez krasnoludów. Można to uargumentować tym, że znajdowała się przy Wielkim Gościńcu Wschodnim, przez który dużo krasnoludów wędrowało do Gór Błękitnych[1]")
            }
            Box(
                modifier = Modifier
                    .padding(16.dp, 50.dp, 16.dp, 50.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Dokładna data założenia karczmy nie jest znana, ale musiało się to zdarzyć po 1601 roku Trzeciej Ery, kiedy to założono Shire[4].\n" +
                            "\n" +
                            "W roku 2941 roku, Bilbo Baggins na swoim kominku znalazł list od Thorina Dębowej Tarczy, który informował go, że jeżeli chce wyruszyć z krasnoludami na wyprawę, musi się stawić w karczmie Pod Zielonym Smokiem[3].\n" +
                            "\n" +
                            "W roku 3018 TE, w karczmie przebywał Samwise Gamgee, gdzie wraz z innymi osobami rozmawiali o entach, a mianowicie o jednym, którego podobno widział jego kuzyn Halfast Gamgee[5]."
                )
            }

            Box(
                modifier = Modifier
                    .padding(16.dp, 50.dp, 16.dp, 50.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Wschodni Gościniec – część niegdyś najdłuższej i jednej z najstarszych dróg Ardy – Drogi Krasnoludów, prowadzącej z zachodniego Beleriandu, przez Ered Luin, aż do Gór Mglistych i dalej prawdopodobnie aż do Orocarni, przecinającej całe Śródziemie z zachodu na wschód.\n" +
                            "\n" +
                            "Mianem Wschodniego Gościńca określano w Trzeciej Erze drogę od Shire do Rivendell, lub też nieco dłuższą trasę od Szarych Przystani do Gór Mglistych. Wędrowcy mogli przekroczyć nim Wysoką Przełęczą (zwaną również Przełęczą Imladris lub Cirith Forn en Andrath) i podążać dalej Starą Leśną Drogą."
                )
            }


        }
    }
}