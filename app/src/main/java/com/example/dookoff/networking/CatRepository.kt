package com.example.dookoff.networking

import com.example.dookoff.model.domain.CatBreedDomain

interface CatRepository {
    suspend fun getCatBreeds(): List<CatBreedDomain>
}