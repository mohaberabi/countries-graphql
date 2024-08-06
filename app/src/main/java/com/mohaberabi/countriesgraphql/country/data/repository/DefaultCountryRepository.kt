package com.mohaberabi.countriesgraphql.country.data.repository

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel
import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository
import com.mohaberabi.countriesgraphql.country.domain.source.CountryRemoteDataSource

class DefaultCountryRepository(
    private val countryRemoteDataSource: CountryRemoteDataSource,
) : CountryRepository {
    override suspend fun getCountry(code: String): Result<CountryDetailModel> {
        return try {
            val country = countryRemoteDataSource.getCountry(code)
            if (country == null) {
                Result.failure(Exception("Could not find country"))
            } else {
                Result.success(country)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun getCountries(): Result<List<CountryListingModel>> {
        return try {
            val countries = countryRemoteDataSource.getCountries()
            Result.success(countries)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}