package com.adncoding.airportflyappinterview.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AirPortFlyDto(
    @SerializedName("FlyType")
    val flyType: String,
    @SerializedName("AirlineID")
    val airlineID: String,
    @SerializedName("Airline")
    val airline: String,
    @SerializedName("FlightNumber")
    val flightNumber: String,
    @SerializedName("DepartureAirportID")
    val departureAirportID: String,
    @SerializedName("DepartureAirport")
    val departureAirport: String,
    @SerializedName("ArrivalAirportID")
    val arrivalAirportID: String,
    @SerializedName("ArrivalAirport")
    val arrivalAirport: String,
    @SerializedName("ScheduleTime")
    val scheduleTime: String,
    @SerializedName("ActualTime")
    val actualTime: String?,
    @SerializedName("EstimatedTime")
    val estimatedTime: String?,
    @SerializedName("Remark")
    val remark: String,
    @SerializedName("Terminal")
    val terminal: String?,
    @SerializedName("Gate")
    val gate: String?,
    @SerializedName("UpdateTime")
    val updateTime: String
)