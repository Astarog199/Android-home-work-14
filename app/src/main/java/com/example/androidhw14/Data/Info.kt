package com.example.androidhw14.Data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Info (
    @Json(name = "seed") val seed: String,
    @Json(name = "results") val results: Int,
    @Json(name = "page") val page: Int,
    @Json(name = "version") val version: String,
)