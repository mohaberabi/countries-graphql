package com.mohaberabi.countriesgraphql.country.domain.usecase.usecases

import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository

class GetCountriesUseCase(
    private val countryRepository: CountryRepository,
) {

    suspend operator fun invoke() = countryRepository.getCountries()
}