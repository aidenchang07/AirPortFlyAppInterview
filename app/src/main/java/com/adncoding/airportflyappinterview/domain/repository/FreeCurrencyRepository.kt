package com.adncoding.airportflyappinterview.domain.repository

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency
import kotlinx.coroutines.flow.Flow

/**
 * Created by AidenChang 2024/03/05
 */
interface FreeCurrencyRepository {
    fun getFreeCurrency(baseCurrency: String): Flow<Resource<FreeCurrency>>
}