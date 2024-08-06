package com.mohaberabi.countriesgraphql.country.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohaberabi.countriesgraphql.country.domain.model.CountryDetailModel


@Composable
fun CountryDetails(
    modifier: Modifier = Modifier,
    details: CountryDetailModel,
) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(
                MaterialTheme.colorScheme.background,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        Text(
            text = details.emoji,
            fontSize = 42.sp,
        )
        Text(
            text = details.name,
        )
        Text(
            text = details.code,
        )
        Text(
            text = details.currency,
        )
    }
}