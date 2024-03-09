package com.adncoding.airportflyappinterview.data.remote

import com.adncoding.airportflyappinterview.common.CurrencyCodes
import com.adncoding.airportflyappinterview.data.remote.dto.FreeCurrencyDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by AidenChang 2024/03/04
 */
interface FreeCurrencyApi {
    @Headers("Accept: application/json")
    @GET("v1/latest")
    suspend fun getFreeCurrencyLatest(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("base_currency") baseCurrency: String = CurrencyCodes.USD
    ): FreeCurrencyDto

    companion object {
        const val API_KEY = "fca_live_wefLQoSWcJbE1lSGfKTGhGID7sQMD4y8ujGLB2Bn"
        const val BASE_URL = "https://api.freecurrencyapi.com/"
    }
}