package com.adncoding.airportflyappinterview.presentation.free_currency

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adncoding.airportflyappinterview.common.CurrencyCodes
import com.adncoding.airportflyappinterview.common.Resource
import com.adncoding.airportflyappinterview.domain.model.Data
import com.adncoding.airportflyappinterview.domain.model.FreeCurrency
import com.adncoding.airportflyappinterview.domain.use_case.GetFreeCurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by AidenChang 2024/03/08
 */
@HiltViewModel
class FreeCurrencyViewModel @Inject constructor(
    private val getFreeCurrency: GetFreeCurrency
): ViewModel(), FreeCurrencyViewModelContract {
    private val _state = mutableStateOf(FreeCurrencyState())
    override val state: State<FreeCurrencyState> = _state

    init {
        loadData(CurrencyCodes.USD)
    }

    override fun loadData(baseCurrency: String) {
        _state.value = _state.value.copy(baseCurrency = baseCurrency)

        viewModelScope.launch {
            getFreeCurrency.invoke(_state.value.baseCurrency).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                        Log.v("testFCResource", "Resource.Loading")
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            freeCurrency = result.data ?: FreeCurrency(
                                data = Data(
                                    aUD = 0.00,
                                    bGN = 0.00,
                                    bRL = 0.00,
                                    cAD = 0.00,
                                    cHF = 0.00,
                                    cNY = 0.00,
                                    cZK = 0.00,
                                    dKK = 0.00,
                                    eUR = 0.00,
                                    gBP = 0.00,
                                    hKD = 0.00,
                                    hRK = 0.00,
                                    hUF = 0.00,
                                    iDR = 0.00,
                                    iLS = 0.00,
                                    iNR = 0.00,
                                    iSK = 0.00,
                                    jPY = 0.00,
                                    kRW = 0.00,
                                    mXN = 0.00,
                                    mYR = 0.00,
                                    nOK = 0.00,
                                    nZD = 0.00,
                                    pHP = 0.00,
                                    pLN = 0.00,
                                    rON = 0.00,
                                    rUB = 0.00,
                                    sEK = 0.00,
                                    sGD = 0.00,
                                    tHB = 0.00,
                                    tRY = 0.00,
                                    uSD = 0.00,
                                    zAR = 0.00
                                )
                            ),
                            error = ""
                        )
                        Log.v("testFCResource", "Resource.Success")
                    }
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                        Log.v("testFCResource", "Resource.Error")
                    }
                }
            }
        }
    }
}