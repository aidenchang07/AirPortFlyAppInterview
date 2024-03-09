package com.adncoding.airportflyappinterview.data.remote.dto


import com.google.gson.annotations.SerializedName

data class FreeCurrencyDto(
    @SerializedName("data")
    val dataDto: DataDto
)