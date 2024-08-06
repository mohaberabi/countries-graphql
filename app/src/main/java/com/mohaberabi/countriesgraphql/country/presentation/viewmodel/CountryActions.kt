package com.mohaberabi.countriesgraphql.country.presentation.viewmodel

sealed interface CountryActions {


    data class OnPressCountry(
        val code: String,
    ) : CountryActions


    data object DismissCountryDialog : CountryActions
}