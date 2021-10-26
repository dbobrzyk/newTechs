package com.example.dookoff.networking

import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.model.mapToDomain
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private val catService: CatService): CatRepository {

    override suspend fun getCatBreeds(): List<CatBreedDomain> {
        val result = catService.getBreeds("1").await()
        return result.mapToDomain()
    }
}