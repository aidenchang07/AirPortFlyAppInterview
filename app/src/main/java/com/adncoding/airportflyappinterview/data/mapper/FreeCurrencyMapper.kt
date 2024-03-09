package com.adncoding.airportflyappinterview.data.mapper

import com.adncoding.airportflyappinterview.data.remote.dto.FreeCurrencyDto
import com.adncoding.airportflyappinterview.domain.model.Data
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency

/**
 * Created by AidenChang 2024/03/05
 */
fun FreeCurrencyDto.toFreeCurrency(): FreeCurrency {
    return FreeCurrency(
        data = Data(
            aUD = dataDto.aUD,
            bGN = dataDto.bGN,
            bRL = dataDto.bRL,
            cAD = dataDto.cAD,
            cHF = dataDto.cHF,
            cNY = dataDto.cNY,
            cZK = dataDto.cZK,
            dKK = dataDto.dKK,
            eUR = dataDto.eUR,
            gBP = dataDto.gBP,
            hKD = dataDto.hKD,
            hRK = dataDto.hRK,
            hUF = dataDto.hUF,
            iDR = dataDto.iDR,
            iLS = dataDto.iLS,
            iNR = dataDto.iNR,
            iSK = dataDto.iSK,
            jPY = dataDto.jPY,
            kRW = dataDto.kRW,
            mXN = dataDto.mXN,
            mYR = dataDto.mYR,
            nOK = dataDto.nOK,
            nZD = dataDto.nZD,
            pHP = dataDto.pHP,
            pLN = dataDto.pLN,
            rON = dataDto.rON,
            rUB = dataDto.rUB,
            sEK = dataDto.sEK,
            sGD = dataDto.sGD,
            tHB = dataDto.tHB,
            tRY = dataDto.tRY,
            uSD = dataDto.uSD,
            zAR = dataDto.zAR,
        )
    )
}