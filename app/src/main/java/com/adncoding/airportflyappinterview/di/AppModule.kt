package com.adncoding.airportflyappinterview.di

import com.adncoding.airportflyappinterview.data.remote.AirPortFlyApi
import com.adncoding.airportflyappinterview.data.remote.FreeCurrencyApi
import com.adncoding.airportflyappinterview.data.repository.AirPortFlyRepositoryImpl
import com.adncoding.airportflyappinterview.data.repository.FreeCurrencyRepositoryImpl
import com.adncoding.airportflyappinterview.domain.repository.AirPortFlyRepository
import com.adncoding.airportflyappinterview.domain.repository.FreeCurrencyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by AidenChang 2024/03/05
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAirPortFlyApi(): AirPortFlyApi {
        return Retrofit.Builder()
            .baseUrl(AirPortFlyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AirPortFlyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAirPortFlyRepository(api: AirPortFlyApi): AirPortFlyRepository {
        return AirPortFlyRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideFreeCurrencyApi(): FreeCurrencyApi {
        return Retrofit.Builder()
            .baseUrl(FreeCurrencyApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FreeCurrencyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFreeCurrencyRepository(api: FreeCurrencyApi): FreeCurrencyRepository {
        return FreeCurrencyRepositoryImpl(api = api)
    }
}