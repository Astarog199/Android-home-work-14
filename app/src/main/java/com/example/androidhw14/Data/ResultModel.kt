package com.example.androidhw14.Data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultModel(
    @Json(name = "results") val results: List<User>,
    @Json(name = "info") val info: Info
)
