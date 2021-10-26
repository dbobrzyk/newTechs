package com.example.dookoff.activity.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Observer
import com.example.dookoff.activity.main.fragment.OffFragment
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
                    HomeView()
                }
            }
        }
        getData()
        Log.d(TAG, "$randomString")
    }

    private fun getData() {
        vm.data.observe(this, Observer { paycheckList ->
            paycheckList[0].let {
                Toast.makeText(
                    this@MainActivity,
                    "Cat breed: ${it.breed} /  pattern: ${it.pattern}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        vm.getData()
    }

}


