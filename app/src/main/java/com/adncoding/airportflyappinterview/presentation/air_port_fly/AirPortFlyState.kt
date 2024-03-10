package com.adncoding.airportflyappinterview.presentation.air_port_fly

import com.adncoding.airportflyappinterview.domain.model.AirPortFly

/**
 * Created by AidenChang 2024/03/05
 */
data class AirPortFlyState(
    val airPortFlyArrivalItems: List<AirPortFly> = emptyList(),
    val airPortFlyDepartureItems: List<AirPortFly> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val updateTimeSec: Int = 10
)