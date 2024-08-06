package com.mohaberabi.countriesgraphql.country.domain.model

data class CountryDetailModel(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val languages: List<String>,
    val continent: String,
)
