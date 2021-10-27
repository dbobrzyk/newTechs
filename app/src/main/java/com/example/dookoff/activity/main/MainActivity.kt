package com.example.dookoff.activity.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dookoff.ui.HomeView
import com.example.dookoff.ui.theme.DoOkOffTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var randomString: String

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoOkOffTheme {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    HomeView(vm.stateOfCats)
                }
            }
        }
        getData()
        Log.d(TAG, "$randomString")
    }

    private fun getData() {
        vm.getData()
    }

}


