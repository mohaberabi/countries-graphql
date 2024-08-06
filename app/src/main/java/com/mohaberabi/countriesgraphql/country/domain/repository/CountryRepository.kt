package com.mohaberabi.countriesgraphql.country.domain.repository

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel

interface CountryRepository {
    suspend fun getCountry(code: String): Result<CountryDetailModel>
    suspend fun getCountries(): Result<List<CountryListingModel>>

}