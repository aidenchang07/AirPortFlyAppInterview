package com.adncoding.airportflyappinterview.domain.use_case

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency
import com.adncoding.airportflyappinterview.domain.repository.FreeCurrencyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/10
 */
class GetFreeCurrency @Inject constructor(
    private val repository: FreeCurrencyRepository
) {
    operator fun invoke(baseCurrency: String): Flow<Resource<FreeCurrency>> {
        return repository.getFreeCurrency(baseCurrency = baseCurrency)
    }
}