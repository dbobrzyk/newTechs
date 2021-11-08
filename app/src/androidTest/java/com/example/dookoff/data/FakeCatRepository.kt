package com.example.dookoff.data

import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.networking.CatRepository

class FakeCatRepository: CatRepository {

    private val catList = mutableListOf<CatBreedDomain>()

    override suspend fun getCatBreeds(): List<CatBreedDomain> {
        return catList
    }

    fun addCat(cat: CatBreedDomain){
        catList.add(cat)
    }

}