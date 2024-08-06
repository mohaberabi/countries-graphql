package com.mohaberabi.countriesgraphql.country.data.source.remote

import com.apollographql.apollo3.ApolloClient
import com.mohaberabi.CountriesQuery
import com.mohaberabi.CountryQuery
import com.mohaberabi.countriesgraphql.country.data.mapper.toCountryDetail
import com.mohaberabi.countriesgraphql.country.data.mapper.toCountryListingModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel
import com.mohaberabi.countriesgraphql.country.domain.source.CountryRemoteDataSource

class ApolloCountryRemoteDataSource(
    private val apollo: ApolloClient
) : CountryRemoteDataSource {
    override suspend fun getCountry(
        code: String,
    ): CountryDetailModel? {
        val query = apollo.query(CountryQuery(code))
            .execute().data
        return query?.country?.toCountryDetail()
    }

    override suspend fun getCountries(): List<CountryListingModel> {
        val query = apollo.query(CountriesQuery()).execute().data
        return query?.countries?.map { it.toCountryListingModel() } ?: listOf()
    }
}


