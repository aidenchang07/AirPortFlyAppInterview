package com.adncoding.airportflyappinterview.data.repository

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.data.mapper.toAirPortFly
import com.adncoding.airportflyappinterview.data.remote.AirPortFlyApi
import com.adncoding.airportflyappinterview.domain.model.AirPortFly
import com.adncoding.airportflyappinterview.domain.repository.AirPortFlyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/05
 */
class AirPortFlyRepositoryImpl @Inject constructor(
    private val api: AirPortFlyApi
): AirPortFlyRepository {
    override fun getAirPortFly(flyType: String): Flow<Resource<List<AirPortFly>>> = flow {
        emit(Resource.Loading())

        runCatching {
            api.getAirPortFlyInfo(flyType, "TPE")
        }.onSuccess { result ->
            emit(Resource.Success(result.map { it.toAirPortFly() }))
        }.onFailure { exception ->
            when (exception) {
                is HttpException -> {
                    emit(Resource.Error(
                        exception.localizedMessage ?: "An unexpected error occurred")
                    )
                }
                is IOException -> {
                    emit(Resource.Error(
                        exception.localizedMessage ?: "Couldn't reach server. Check your internet connection.")
                    )
                }
            }
        }
    }
}