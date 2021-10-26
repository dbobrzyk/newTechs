package com.example.dookoff.model

import com.example.dookoff.model.domain.CatBreedDomain
import com.example.dookoff.model.rest.CatBreedsList


fun CatBreedsList.mapToDomain(): List<CatBreedDomain> {
    return this.data.map {
        CatBreedDomain(
            breed = it.breed,
            coat = it.coat,
            country = it.country,
            origin = it.origin,
            pattern = it.pattern
        )
    }
}

