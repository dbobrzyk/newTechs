package com.example.dookoff.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dookoff.ui.HomeView
import com.example.dookoff.ui.theme.DoOkOffTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val TAG = "MainActivity"

    @Preview
    @Composable
    fun ComposablePreview() {
        HomeView(vm.stateOfCats)
    }

    @Inject
    lateinit var randomString: String

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoOkOffTheme {
                Column {
                    HomeView(vm.stateOfCats)
                }
            }
        }
        getData()
    }

    private fun getData() {
        vm.getData()
    }

}



