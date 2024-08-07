package com.mohaberabi.countriesgraphql

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEmpty
import org.junit.Test

class TestEnv {


    @Test
    fun `api key must  have value `() {
        assertThat(BuildConfig.API_KEY).isEqualTo("mohabLoser")
    }
}