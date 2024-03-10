package com.adncoding.airportflyappinterview.presentation.free_currency

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.adncoding.airportflyappinterview.domain.model.Data
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency

/**
 * Created by AidenChang 2024/03/10
 */
class MockFreeCurrencyViewModel : FreeCurrencyViewModelContract {
    override val state: State<FreeCurrencyState>
        get() = mutableStateOf(FreeCurrencyState(
            isLoading = false,
            freeCurrency = FreeCurrency(
                data = Data(
                    aUD = 0.0,
                    bGN = 0.0,
                    bRL = 0.0,
                    cAD = 0.0,
                    cHF = 0.0,
                    cNY = 0.0,
                    cZK = 0.0,
                    dKK = 0.0,
                    eUR = 0.0,
                    gBP = 0.0,
                    hKD = 0.0,
                    hRK = 0.0,
                    hUF = 0.0,
                    iDR = 0.0,
                    iLS = 0.0,
                    iNR = 0.0,
                    iSK = 0.0,
                    jPY = 0.0,
                    kRW = 0.0,
                    mXN = 0.0,
                    mYR = 0.0,
                    nOK = 0.0,
                    nZD = 0.0,
                    pHP = 0.0,
                    pLN = 0.0,
                    rON = 0.0,
                    rUB = 0.0,
                    sEK = 0.0,
                    sGD = 0.0,
                    tHB = 0.0,
                    tRY = 0.0,
                    uSD = 0.0,
                    zAR = 0.0
                )
            ),
            error = ""
        ))

    override fun loadData(baseCurrency: String) {}
}