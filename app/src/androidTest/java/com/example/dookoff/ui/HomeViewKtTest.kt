package com.example.dookoff.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.dookoff.activity.main.MainActivity
import com.example.dookoff.data.FakeCatRepository
import com.example.dookoff.di.AppModule
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.networking.CatRepositoryImpl
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@UninstallModules(AppModule::class)
class HomeViewKtTest {


    @get:Rule()
    val hiltRule = HiltAndroidRule(this)

    @get:Rule()
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var catsRepository: FakeCatRepository

    @Before
    fun setUp() {
        hiltRule.inject()

        (1..10).forEach {
            catsRepository.addCat(
                CatBreedDomain("cat no $it", "", "", "", "")
            )
        }

        runBlocking {
            catsRepository.getCatBreeds().let {
                composeRule.setContent {
                    HomeView(
                        stateOfCats = mutableStateOf(it),
                        context = composeRule.activity.baseContext
                    )
                }
            }
        }
    }

    @Test
    fun whatever_test() {
        composeRule.onNodeWithTag("reservationView").assertIsDisplayed()
    }

    @Test
    fun check_bottom_nav_to_cats() {
        composeRule.onNodeWithTag("bottom1").performClick()
        composeRule.onNodeWithTag("catsView").assertIsDisplayed()
        composeRule.onNodeWithTag("offDaysView").assertDoesNotExist()
        composeRule.onNodeWithTag("reservationView").assertDoesNotExist()
    }

    @Test
    fun check_bottom_nav_to_off_days() {
        composeRule.onNodeWithTag("bottom0").performClick()
        composeRule.onNodeWithTag("offDaysView").assertIsDisplayed()
        composeRule.onNodeWithTag("catsView").assertDoesNotExist()
        composeRule.onNodeWithTag("reservationView").assertDoesNotExist()
    }

    @Test
    fun check_bottom_nav_to_reservations() {
        composeRule.onNodeWithTag("bottom2").performClick()
        composeRule.onNodeWithTag("reservationView").assertIsDisplayed()
        composeRule.onNodeWithTag("offDaysView").assertDoesNotExist()
        composeRule.onNodeWithTag("catsView").assertDoesNotExist()
    }

    @Test
    fun check_multiple_navs_on_bottom_bar() {
        check_bottom_nav_to_cats()
        check_bottom_nav_to_off_days()
        check_bottom_nav_to_reservations()
        check_bottom_nav_to_reservations()

        check_bottom_nav_to_cats()
        check_bottom_nav_to_reservations()
        check_bottom_nav_to_cats()
    }

    @Test
    fun check_details_button_displaying_dialog(){
        check_bottom_nav_to_off_days()
        composeRule.onAllNodesWithText("Szczegóły")[0].performClick()
        composeRule.onAllNodesWithText("Witamy w dialogu Jetpack Compose")[0].assertIsDisplayed()
        composeRule.onAllNodesWithText("Confirm")[0].performClick()
        composeRule.onNodeWithText("Witamy w dialogu Jetpack Compose").assertDoesNotExist()
    }
}