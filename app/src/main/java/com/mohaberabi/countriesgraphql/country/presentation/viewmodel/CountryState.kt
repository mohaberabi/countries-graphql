package com.mohaberabi.countriesgraphql.country.presentation.viewmodel

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel


enum class CountryStatus {
    Initial,
    Loading,
    Error,
    Populated,
}

data class CountryState(
    val state: CountryStatus = CountryStatus.Initial,
    val countries: List<CountryListingModel> = listOf(),
    val choosedCountry: CountryDetailModel? = null,
)
