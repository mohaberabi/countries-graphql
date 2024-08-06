package com.mohaberabi.countriesgraphql.country.presentation.viewmodel

sealed interface CountryEvents {


    data class Error(val error: String) : CountryEvents
}