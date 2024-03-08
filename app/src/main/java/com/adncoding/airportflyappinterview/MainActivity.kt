package com.adncoding.airportflyappinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adncoding.airportflyappinterview.presentation.air_port_fly.AirPortFlyScreen
import com.adncoding.airportflyappinterview.presentation.air_port_fly.NavItemState
import com.adncoding.airportflyappinterview.presentation.free_currency.FreeCurrencyScreen
import com.adncoding.airportflyappinterview.ui.theme.AirPortFlyAppInterviewTheme
import com.example.travelappinterview.presentation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val items = listOf(
                NavItemState(
                    title = stringResource(id = R.string.flight),
                    selectedIcon = painterResource(id = R.drawable.flight),
                    unselectedIcon = painterResource(id = R.drawable.flight),
                    route = Screen.AirPortFlyScreen.route
                ),
                NavItemState(
                    title = stringResource(id = R.string.currency),
                    selectedIcon = painterResource(id = R.drawable.currency),
                    unselectedIcon = painterResource(id = R.drawable.currency),
                    route = Screen.FreeCurrencyScreen.route
                )
            )

            AirPortFlyAppInterviewTheme {
                var bottomNavState by rememberSaveable {
                    mutableIntStateOf(0)
                }
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        NavigationBar(
                            containerColor = MaterialTheme.colorScheme.surface
                        ) {
                            items.forEachIndexed { index, navItemState ->
                                NavigationBarItem(
                                    selected = bottomNavState == index,
                                    onClick = {
                                        bottomNavState = index
                                        navController.navigate(navItemState.route)
                                    },
                                    icon = {
                                        Icon(
                                            modifier = Modifier.size(24.dp),
                                            painter = if (bottomNavState == index) {
                                                navItemState.selectedIcon
                                            } else navItemState.unselectedIcon,
                                            contentDescription = navItemState.title
                                        )
                                    },
                                    label = {
                                        Text(text = navItemState.title)
                                    }
                                )
                            }
                        }
                    }
                ) { it
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AirPortFlyScreen.route
                    ) {
                        composable(
                            route = Screen.AirPortFlyScreen.route
                        ) {
                            AirPortFlyScreen()
                        }
                        composable(
                            route = Screen.FreeCurrencyScreen.route
                        ) {
                            FreeCurrencyScreen()
                        }
                    }
                }
            }
        }
    }
}