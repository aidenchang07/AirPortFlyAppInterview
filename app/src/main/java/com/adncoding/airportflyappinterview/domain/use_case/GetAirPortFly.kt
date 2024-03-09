package com.adncoding.airportflyappinterview.domain.use_case

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.AirPortFly
import com.adncoding.airportflyappinterview.domain.repository.AirPortFlyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/05
 */
class GetAirPortFly @Inject constructor(
    private val repository: AirPortFlyRepository
) {
    operator fun invoke(flyType: String): Flow<Resource<List<AirPortFly>>> {
        return repository.getAirPortFly(flyType)
    }
}