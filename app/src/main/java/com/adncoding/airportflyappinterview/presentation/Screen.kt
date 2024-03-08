package com.example.travelappinterview.presentation

/**
 * Created by AidenChang 2024/02/22
 */
sealed class Screen(val route: String) {
    data object AirPortFlyScreen: Screen("air_port_fly_screen")
    data object FreeCurrencyScreen: Screen("free_currency_screen")
}