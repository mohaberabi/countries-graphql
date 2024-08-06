package com.mohaberabi.countriesgraphql.country.domain.usecase

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel
import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository
import com.mohaberabi.countriesgraphql.generator.FakeCountryGenerator

class FakeCountryRepository : CountryRepository {


    private var returnError: Boolean = false


    var invokes: Int = 0
        private set
    var error = Exception("Ooops")
        private set

    fun setShouldThrowError(
        shouldThrow: Boolean,
    ) {
        returnError = shouldThrow
    }

    override suspend fun getCountry(
        code: String,
    ): Result<CountryDetailModel> {
        invokes++
        return throwOrReturn {
            FakeCountryGenerator.country
        }
    }


    override suspend fun getCountries(): Result<List<CountryListingModel>> {
        invokes++
        return throwOrReturn {
            FakeCountryGenerator.countries
        }

    }


    private fun <T> throwOrReturn(data: () -> T): Result<T> {
        return if (returnError) {
            Result.failure(error)
        } else {
            Result.success(data())
        }
    }

}