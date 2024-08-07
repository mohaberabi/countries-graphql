package com.mohaberabi.countriesgraphql.country.presentation.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.window.Dialog
import com.mohaberabi.countriesgraphql.BuildConfig
import com.mohaberabi.countriesgraphql.country.presentation.compose.CountryDetails
import com.mohaberabi.countriesgraphql.country.presentation.compose.CountryRow
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryActions
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryEvents
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryState
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryStatus
import com.mohaberabi.countriesgraphql.country.presentation.viewmodel.CountryViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun CountryScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: CountryViewModel = koinViewModel(),
) {

    val context = LocalContext.current


    LaunchedEffect(key1 = Unit) {

        // simulate need  of buildConfig
        Log.d("loser", BuildConfig.API_KEY)
    }
    LaunchedEffect(
        key1 = viewModel.event,
    ) {
        viewModel.event.collect {
            when (it) {
                is CountryEvents.Error -> Toast.makeText(
                    context, it.error, Toast.LENGTH_LONG,
                )
                    .show()
            }
        }

    }
    val state by viewModel.state.collectAsState()
    CountryScreen(
        state = state,
        onAction = viewModel::onAction
    )

}

@Composable
fun CountryScreen(
    modifier: Modifier = Modifier,
    state: CountryState,
    onAction: (CountryActions) -> Unit,
) {

    Scaffold(
        modifier = modifier,
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            when (state.state) {
                CountryStatus.Error -> Text(
                    text = "Something went wrong ",
                )

                CountryStatus.Populated -> {
                    LazyColumn(
                    ) {
                        item {

                        }
                        items(state.countries) { country ->

                            CountryRow(
                                onClick = {
                                    onAction(CountryActions.OnPressCountry(country.code))
                                },
                                country = country,
                            )
                        }

                    }
                }

                else -> CircularProgressIndicator()
            }

            state.choosedCountry?.let {

                Dialog(
                    onDismissRequest = {
                        onAction(CountryActions.DismissCountryDialog)
                    },
                ) {

                    CountryDetails(
                        details = it,
                    )
                }
            }
        }

    }
}