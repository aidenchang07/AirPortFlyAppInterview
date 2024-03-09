package com.adncoding.airportflyappinterview.data.remote

import com.adncoding.airportflyappinterview.data.remote.dto.AirPortFlyDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Created by AidenChang 2024/03/04
 */
interface AirPortFlyApi {
    @Headers("Accept: application/json")
    @GET("api/AirPortFlyAPI/{flyType}/{airPortID}")
    suspend fun getAirPortFlyInfo(
        @Path("flyType") flyType: String,
        @Path("airPortID") airPortID: String
    ): List<AirPortFlyDto>

    companion object {
        const val BASE_URL = "https://e-traffic.taichung.gov.tw/DataAPI/"
    }
}