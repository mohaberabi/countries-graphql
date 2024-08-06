package com.mohaberabi.countriesgraphql.country.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohaberabi.countriesgraphql.country.domain.usecase.CountryUseCases
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

class CountryViewModel(
    private val useCases: CountryUseCases,
) : ViewModel() {


    private val _state = MutableStateFlow(CountryState())
    val state = _state.asStateFlow()


    private val _event = Channel<CountryEvents>()
    val event = _event.receiveAsFlow()

    init {
        getCountries()
    }

    fun onAction(action: CountryActions) {
        when (action) {
            is CountryActions.OnPressCountry -> getCountry(action.code)
            CountryActions.DismissCountryDialog -> _state.update { it.copy(choosedCountry = null) }
        }
    }

    private fun getCountries() {
        _state.update { it.copy(state = CountryStatus.Loading) }
        viewModelScope.launch {
            useCases.getCountriesUseCase().onFailure {
                _state.update { it.copy(state = CountryStatus.Error) }
            }.onSuccess { conts ->
                _state.update { it.copy(state = CountryStatus.Populated, countries = conts) }
            }
        }
    }

    private fun getCountry(code: String) {
        viewModelScope.launch {
            val res = useCases.getCountryUseCase(code)
            res.onFailure {
                _event.send(CountryEvents.Error(it.message ?: "Unknown Error"))
            }.onSuccess { country ->
                _state.update { it.copy(choosedCountry = country) }
            }
        }
    }
}