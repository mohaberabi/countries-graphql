package com.mohaberabi.countriesgraphql.country.di

import com.apollographql.apollo3.ApolloClient
import com.mohaberabi.countriesgraphql.country.data.repository.DefaultCountryRepository
import com.mohaberabi.countriesgraphql.country.data.source.remote.ApolloCountryRemoteDataSource
import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository
import com.mohaberabi.countriesgraphql.country.domain.source.CountryRemoteDataSource
import com.mohaberabi.countriesgraphql.country.domain.usecase.CountryUseCases
import com.mohaberabi.countriesgraphql.country.domain.usecase.usecases.GetCountriesUseCase
import com.mohaberabi.countriesgraphql.country.domain.usecase.usecases.GetCountryUseCase
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


val appModule = module {


    single {
        GetCountriesUseCase(get())
    }
    single {
        GetCountryUseCase(get())
    }


    single { CountryUseCases(get(), get()) }

    single<CountryRepository> {
        DefaultCountryRepository(get())
    }

    single<ApolloClient> {
        ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/graphql").build()
    }
    single<CountryRemoteDataSource> {
        ApolloCountryRemoteDataSource(get())
    }
    viewModelOf(::CountryViewModel)
}