package com.adncoding.airportflyappinterview.presentation.free_currency

import androidx.compose.runtime.State

interface FreeCurrencyViewModelContract {
    val state: State<FreeCurrencyState>
    fun loadData(baseCurrency: String)
}