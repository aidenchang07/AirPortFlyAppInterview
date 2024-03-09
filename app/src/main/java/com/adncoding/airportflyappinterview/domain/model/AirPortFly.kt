package com.adncoding.airportflyappinterview.domain.model

/**
 * Created by AidenChang 2024/03/04
 */
data class AirPortFly(
    val flyType: String,
    val airlineID: String,
    val airline: String,
    val flightNumber: String,
    val departureAirportID: String,
    val departureAirport: String,
    val arrivalAirportID: String,
    val arrivalAirport: String,
    val scheduleTime: String,
    val actualTime: String,
    val estimatedTime: String,
    val remark: String,
    val terminal: String,
    val gate: String,
    val updateTime: String
)