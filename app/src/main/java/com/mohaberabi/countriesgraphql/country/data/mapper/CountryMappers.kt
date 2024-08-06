package com.mohaberabi.countriesgraphql.country.data.mapper

import com.mohaberabi.CountriesQuery
import com.mohaberabi.CountryQuery
import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel

fun CountryQuery.Country.toCountryDetail() = CountryDetailModel(
    code = code,
    continent = continent.name,
    name = name,
    currency = currency ?: "",
    emoji = emoji,
    languages = languages.map { it.name },
    capital = capital ?: ""
)

fun CountriesQuery.Country.toCountryListingModel() = CountryListingModel(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: ""
)