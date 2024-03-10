package com.adncoding.airportflyappinterview.presentation.free_currency

import com.adncoding.airportflyappinterview.common.CurrencyCodes
import com.adncoding.airportflyappinterview.domain.model.Data
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency

/**
 * Created by AidenChang 2024/03/10
 */
data class FreeCurrencyState(
    val baseCurrency: String = CurrencyCodes.USD,
    val freeCurrency: FreeCurrency = FreeCurrency(Data(
        aUD = 0.00,
        bGN = 0.00,
        bRL = 0.00,
        cAD = 0.00,
        cHF = 0.00,
        cNY = 0.00,
        cZK = 0.00,
        dKK = 0.00,
        eUR = 0.00,
        gBP = 0.00,
        hKD = 0.00,
        hRK = 0.00,
        hUF = 0.00,
        iDR = 0.00,
        iLS = 0.00,
        iNR = 0.00,
        iSK = 0.00,
        jPY = 0.00,
        kRW = 0.00,
        mXN = 0.00,
        mYR = 0.00,
        nOK = 0.00,
        nZD = 0.00,
        pHP = 0.00,
        pLN = 0.00,
        rON = 0.00,
        rUB = 0.00,
        sEK = 0.00,
        sGD = 0.00,
        tHB = 0.00,
        tRY = 0.00,
        uSD = 0.00,
        zAR = 0.00
    )),
    val isLoading: Boolean = false,
    val error: String = ""
)