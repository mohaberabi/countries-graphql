package com.mohaberabi.countriesgraphql.generator

import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel

class FakeCountryGenerator {


    companion object {
        val country = CountryDetailModel(
            "eg",
            "eg", "eg", "eg", "eg", listOf(), ""
        )
        val countries = listOf(CountryListingModel("", "", "", ""))
    }
}