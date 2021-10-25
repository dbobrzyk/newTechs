package com.example.dookoff.model.rest

import com.google.gson.annotations.SerializedName

data class CatFactRest(
    @SerializedName("fact")
    val factText: String,
    @SerializedName("length")
    val lenghtOfText: Int
)

