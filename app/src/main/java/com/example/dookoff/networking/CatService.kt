package com.example.dookoff.networking

import com.example.dookoff.model.rest.CatBreedsList
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {

    @GET("breeds")
    fun getBreeds(@Query("limit") limit: String): Deferred<CatBreedsList>

    @GET("fact")
    fun getFact(): Deferred<String>

    companion object{
        const val URL = "https://catfact.ninja/"
    }
}