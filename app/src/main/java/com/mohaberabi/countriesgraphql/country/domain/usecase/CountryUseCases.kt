package com.mohaberabi.countriesgraphql.country.domain.usecase

import com.mohaberabi.countriesgraphql.country.domain.usecase.usecases.GetCountriesUseCase
import com.mohaberabi.countriesgraphql.country.domain.usecase.usecases.GetCountryUseCase

data class CountryUseCases(
    val getCountryUseCase: GetCountryUseCase,
    val getCountriesUseCase: GetCountriesUseCase,
)