package com.adncoding.airportflyappinterview.presentation.free_currency

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adncoding.airportflyappinterview.common.CurrencyCodes
import com.adncoding.airportflyappinterview.presentation.free_currency.components.FreeCurrencyItem

/**
 * Created by AidenChang 2024/03/08
 */
@Composable
fun FreeCurrencyScreen() {
    val viewModel: FreeCurrencyViewModelContract =
        if (LocalInspectionMode.current) {
            MockFreeCurrencyViewModel()
        } else {
            hiltViewModel<FreeCurrencyViewModel>()
        }
    val state = viewModel.state.value
    val scrollState = rememberScrollState()
//    val updateTime by viewModel.updateTimeSec.collectAsState()

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            text = state.updateTimeSec.toString(),
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        Box {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.JPY,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.JPY,
                    symbol = "¥",
                    value = state.freeCurrency.data.jPY,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.JPY)
                    }
                )
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.USD,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.USD,
                    symbol = "$",
                    value = state.freeCurrency.data.uSD,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.USD)
                    }
                )
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.CNY,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.CNY,
                    symbol = "¥",
                    value = state.freeCurrency.data.cNY,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.CNY)
                    }
                )
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.EUR,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.EUR,
                    symbol = "€",
                    value = state.freeCurrency.data.eUR,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.EUR)
                    }
                )
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.AUD,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.AUD,
                    symbol = "$",
                    value = state.freeCurrency.data.aUD,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.AUD)
                    }
                )
                FreeCurrencyItem(
                    borderModifier = Modifier.getBorderModifierByCurrencyCode(
                        itemCurrencyCode = CurrencyCodes.KRW,
                        currencyCode = state.baseCurrency
                    ),
                    name = CurrencyCodes.KRW,
                    symbol = "₩",
                    value = state.freeCurrency.data.kRW,
                    onItemClick = {
                        viewModel.loadData(CurrencyCodes.KRW)
                    }
                )
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

private fun Modifier.getBorderModifierByCurrencyCode(
    itemCurrencyCode: String,
    currencyCode: String
): Modifier = composed {
    if (itemCurrencyCode == currencyCode) {
        this.then(
            Modifier.border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium
            )
        )
    } else {
        this.then(
            Modifier.border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FreeCurrencyScreenPreview() {
    FreeCurrencyScreen()
}