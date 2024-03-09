package com.adncoding.airportflyappinterview.data.repository

import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.data.mapper.toFreeCurrency
import com.adncoding.airportflyappinterview.data.remote.FreeCurrencyApi
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency
import com.adncoding.airportflyappinterview.domain.repository.FreeCurrencyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/05
 */
class FreeCurrencyRepositoryImpl @Inject constructor(
    private val api: FreeCurrencyApi
): FreeCurrencyRepository {
    override fun getFreeCurrency(): Flow<Resource<FreeCurrency>> = flow {
        emit(Resource.Loading())

        runCatching {
            api.getFreeCurrencyLatest()
        }.onSuccess { result ->
            emit(Resource.Success(result.toFreeCurrency()))
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