package com.adncoding.airportflyappinterview.domain.repository

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.AirPortFly
import kotlinx.coroutines.flow.Flow

/**
 * Created by AidenChang 2024/03/05
 */
interface AirPortFlyRepository {
    fun getAirPortFly(flyType: String): Flow<Resource<List<AirPortFly>>>
}