package com.example.dookoff.activity.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dookoff.model.rest.Data
import com.example.dookoff.networking.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val retrofitClient: RetrofitClient) : ViewModel() {

    val data = MutableLiveData<List<Data>>()

    fun getData() {
        runBlocking {
            val result = retrofitClient.getTestApi().getBreeds("1").await()
            data.value = result.data
        }
    }

}