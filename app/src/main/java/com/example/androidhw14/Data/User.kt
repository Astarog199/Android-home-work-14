package com.example.androidhw14.Data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class User (
    @Json(name = "gender") val gender: String,
    @Json(name = "name") val name: Map<String, String>,
    @Json(name = "location")val location: Location,
    @Json(name = "email") val email: String,
    @Json(name = "login") val login: Map<String, String>,
    @Json(name = "dob") val dob: Dob,
    @Json(name = "registered") val registered: Registered,
    @Json(name = "phone") val phone: String,
    @Json(name = "cell") val cell: String,
    @Json(name = "id") val id: Map<String, String>,
    @Json(name = "picture") val picture: Map<String, String>,
    @Json(name = "nat") val nat: String,
)

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "street") val street: Street,
    @Json(name = "city") val city: String,
    @Json(name = "state") val state: String,
    @Json(name = "country") val country: String,
    @Json(name = "postcode") val postcode: String,
    @Json(name = "coordinates") val coordinates:  Map<String, String>,
    @Json(name = "timezone") val timezone:  Map<String, String>,
)

@JsonClass(generateAdapter = true)
data class Street(
    @Json(name = "number") val number: Int,
    @Json(name = "name") val name: String
)

@JsonClass(generateAdapter = true)
data class Dob(
    @Json(name = "date") val date: String,
    @Json(name = "age") val age: Int
)

@JsonClass(generateAdapter = true)
data class Registered(
    val date: String,
    val age: Int
)