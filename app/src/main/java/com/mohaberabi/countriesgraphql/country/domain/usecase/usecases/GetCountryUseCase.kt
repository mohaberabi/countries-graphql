package com.mohaberabi.countriesgraphql.country.domain.usecase.usecases

import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository

class GetCountryUseCase(
    private val countryRepository: CountryRepository,
) {
    suspend operator fun invoke(
        code: String,
    ) = countryRepository.getCountry(code)
}