package com.mohaberabi.countriesgraphql.country.domain.model

data class CountryListingModel(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
)
