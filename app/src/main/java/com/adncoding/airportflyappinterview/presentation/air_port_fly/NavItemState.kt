package com.adncoding.airportflyappinterview.presentation.air_port_fly

import androidx.compose.ui.graphics.painter.Painter

/**
 * Created by AidenChang 2024/03/08
 */
data class NavItemState(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val route: String
)
