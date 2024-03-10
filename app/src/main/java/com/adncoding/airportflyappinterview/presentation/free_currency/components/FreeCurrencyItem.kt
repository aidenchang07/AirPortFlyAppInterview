package com.adncoding.airportflyappinterview.presentation.free_currency.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adncoding.airportflyappinterview.R

/**
 * Created by AidenChang 2024/03/10
 */
@Composable
fun FreeCurrencyItem(
    borderModifier: Modifier = Modifier,
    name: String,
    symbol: String,
    value: Double,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 0.dp,
            end = 16.dp,
            bottom = 16.dp
        ).then(borderModifier)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    fontFamily = FontFamily(Font(R.font.inter_regular))
                )
            }
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "$symbol $value",
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
            }
        }
    }
}

@Preview
@Composable
private fun FreeCurrencyItemPreview() {
    FreeCurrencyItem(
        borderModifier = Modifier,
        name = "USD",
        symbol = "$",
        value = 0.00,
        onItemClick = {}
    )
}