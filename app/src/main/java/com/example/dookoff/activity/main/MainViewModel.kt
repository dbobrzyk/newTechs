package com.example.dookoff.activity.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.networking.CatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val catRepository: CatRepository) : ViewModel() {

    val stateOfCats : MutableState<List<CatBreedDomain>> = mutableStateOf(listOf())

    fun getData() {
        runBlocking {
            val result = catRepository.getCatBreeds()
            stateOfCats.value = result
        }
    }

}