package com.mohaberabi.countriesgraphql.country.domain.usecase

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isFalse
import assertk.assertions.isInstanceOf
import assertk.assertions.isTrue
import com.mohaberabi.countriesgraphql.country.domain.repository.CountryRepository
import com.mohaberabi.countriesgraphql.country.domain.usecase.usecases.GetCountryUseCase
import com.mohaberabi.countriesgraphql.generator.FakeCountryGenerator
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TestGetCountryUseCase {


    private lateinit var getCountryUseCase: GetCountryUseCase

    private lateinit var countryRepository: FakeCountryRepository

    @Before

    fun setup() {

        countryRepository = FakeCountryRepository()
        getCountryUseCase = GetCountryUseCase(countryRepository)
    }


    @Test
    fun `should return country  from result success `() = runTest {


        val res = getCountryUseCase("any")

        assertThat(res.isFailure).isFalse()
        assertThat(res.isSuccess).isTrue()
        assertThat(countryRepository.invokes).isEqualTo(1)
        res.onSuccess {
            assertThat(it).isEqualTo(FakeCountryGenerator.country)
        }
    }

    @Test
    fun `should not  return country returns  failure  result failure `() = runTest {


        countryRepository.setShouldThrowError(true)
        val res = getCountryUseCase("any")

        assertThat(res.isFailure).isTrue()
        assertThat(res.isSuccess).isFalse()
        assertThat(countryRepository.invokes).isEqualTo(1)
        res.onFailure {
            assertThat(it).isEqualTo(countryRepository.error)
        }
    }


}