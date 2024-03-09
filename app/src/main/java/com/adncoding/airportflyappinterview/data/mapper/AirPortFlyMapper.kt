package com.adncoding.airportflyappinterview.data.mapper

import com.adncoding.airportflyappinterview.data.remote.dto.AirPortFlyDto
import com.adncoding.airportflyappinterview.domain.model.AirPortFly

/**
 * Created by AidenChang 2024/03/04
 */
fun AirPortFlyDto.toAirPortFly(): AirPortFly {
    return AirPortFly(
        flyType = flyType,
        airlineID = airlineID,
        airline = airline,
        flightNumber = flightNumber,
        departureAirportID = departureAirportID,
        departureAirport = departureAirport,
        arrivalAirportID = arrivalAirportID,
        arrivalAirport = arrivalAirport,
        scheduleTime = scheduleTime,
        actualTime = actualTime ?: "None",
        estimatedTime = estimatedTime ?: "None",
        remark = remark,
        terminal = terminal ?: "None",
        gate = gate ?: "None",
        updateTime = updateTime
    )
}