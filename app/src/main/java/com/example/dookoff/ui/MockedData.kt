package com.example.dookoff.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dookoff.model.domain.DayOff
import com.example.dookoff.model.domain.DayOffApplication
import java.util.*

//Test lists just to mock the data
val day = 86400000
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
        dateStart = Date(Date().time - (14 * day)),
        dateEnd = Date(Date().time - (7 * day)),
        isHistorical = true,
        isInProgress = true,
        timeInDays = 7
    ),
    DayOff(
        dateStart = Date(Date().time - (21 * day)),
        dateEnd = Date(Date().time - (20 * day)),
        isHistorical = true,
        isInProgress = false,
        timeInDays = 1
    ),
    DayOff(
        dateStart = Date(),
        dateEnd = Date(Date().time + 457635),
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


@Composable
fun TextMockedRows() {
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