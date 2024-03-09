package com.adncoding.airportflyappinterview.presentation.air_port_fly

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adncoding.airportflyappinterview.common.FlyType
import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.AirPortFly
import com.adncoding.airportflyappinterview.domain.use_case.GetAirPortFly
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/05
 */
@HiltViewModel
class AirPortFlyViewModel @Inject constructor(
    private val getAirPortFly: GetAirPortFly
): ViewModel() {
    private val _state = mutableStateOf(AirPortFlyState())
    val state: State<AirPortFlyState> = _state
    private val isDataLoaded = mutableMapOf<String, Boolean>().apply {
        put(FlyType.ARRIVAL, false)
        put(FlyType.DEPARTURE, false)
    }

    fun loadData(flyType: String) {
        if (isDataLoaded[flyType] == true) return
        viewModelScope.launch {
            getAirPortFly(flyType).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                        Log.v("testResource", "Resource.Loading")
                    }
                    is Resource.Success -> {
                        _state.value = airPortFlyStateSelector(result, flyType)
                        isDataLoaded[flyType] = true
                        Log.v("testResource", "Resource.Success")
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                        Log.v("testResource", "Resource.Error")
                    }
                }
            }.launchIn(this)
        }
    }

    private fun airPortFlyStateSelector(result: Resource<List<AirPortFly>>, flyType: String): AirPortFlyState {
        return when (flyType) {
            FlyType.ARRIVAL -> {
                _state.value.copy(
                    isLoading = false,
                    airPortFlyArrivalItems = result.data ?: emptyList(),
                    error = ""
                )
            }
            FlyType.DEPARTURE -> {
                _state.value.copy(
                    isLoading = false,
                    airPortFlyDepartureItems = result.data ?: emptyList(),
                    error = ""
                )
            }
            else -> {
                throw RuntimeException("flyType: $flyType")
            }
        }
    }

    fun cleanData() {
        _state.value = _state.value.copy(
            airPortFlyArrivalItems = emptyList(),
            airPortFlyDepartureItems = emptyList()
        )
    }
}