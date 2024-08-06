package com.mohaberabi.countriesgraphql.country.domain.source

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel

interface CountryRemoteDataSource {

    suspend fun getCountries(): List<CountryListingModel>

    suspend fun getCountry(
        code: String,
    ): CountryDetailModel?
}