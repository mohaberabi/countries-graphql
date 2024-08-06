package com.mohaberabi.countriesgraphql.country.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohaberabi.countriesgraphql.country.domain.model.CountryListingModel


@Composable
fun CountryRow(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    country: CountryListingModel
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onClick() },
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = country.emoji,
                fontSize = 20.sp,
            )

            Spacer(
                modifier = Modifier.width(4.dp),
            )

            Text(
                text = country.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            )

        }

        Text(
            text = country.code,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }

}