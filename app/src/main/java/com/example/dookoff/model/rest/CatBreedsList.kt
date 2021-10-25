package com.example.dookoff.model.rest

import com.squareup.moshi.Json

data class CatBreedsList(
    @Json(name = "current_page")
    val current_page: Int,
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "first_page_url")
    val first_page_url: String,
    @Json(name = "from")
    val from: Int,
    @Json(name = "last_page")
    val last_page: Int,
    @Json(name = "last_page_url")
    val last_page_url: String,
    @Json(name = "links")
    val links: List<Link>,
    @Json(name = "next_page_url")
    val next_page_url: String,
    @Json(name = "path")
    val path: String,
    @Json(name = "per_page")
    val per_page: Int,
    @Json(name = "prev_page_url")
    val prev_page_url: Any,
    @Json(name = "to")
    val to: Int,
    @Json(name = "total")
    val total: Int
)