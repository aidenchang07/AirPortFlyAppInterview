package com.adncoding.airportflyappinterview.presentation.air_port_fly

import com.adncoding.airportflyappinterview.R

/**
 * Created by AidenChang 2024/03/05
 */
enum class AirPortFlyTabs(
    val iconId: Int,
    val stringId: Int
) {
    Takeoff(
        iconId = R.drawable.plane_takeoff,
        stringId = R.string.plane_takeoff
    ),
    Landing(
        iconId = R.drawable.plane_landing,
        stringId = R.string.plane_landing
    )
}