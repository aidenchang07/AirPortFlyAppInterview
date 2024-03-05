package com.adncoding.airportflyappinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adncoding.airportflyappinterview.ui.theme.AirPortFlyAppInterviewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirPortFlyAppInterviewTheme {

            }
        }
    }
}