package com.adncoding.airportflyappinterview.presentation.air_port_fly

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adncoding.airportflyappinterview.presentation.air_port_fly.components.AirPortFlyItem
import kotlinx.coroutines.launch

/**
 * Created by AidenChang 2024/03/05
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AirPortFlyScreen(
    viewModel: AirPortFlyViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    val pagerState = rememberPagerState(
        pageCount = {
            AirPortFlyTabs.entries.size
        }
    )
    val selectedTabIndex by remember { derivedStateOf { pagerState.currentPage } }

    LaunchedEffect(selectedTabIndex) {
        when (selectedTabIndex) {
            FlyType.DEPARTURE.ordinal -> {
                Log.v("testLaunchedEffect", "is Departure")
                viewModel.loadData(FlyType.DEPARTURE.type)
            }
            FlyType.ARRIVAL.ordinal -> {
                Log.v("testLaunchedEffect", "is Arrival")
                viewModel.loadData(FlyType.ARRIVAL.type)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex
        ) {
            AirPortFlyTabs.entries.forEachIndexed { index, currentTab ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.outline,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    text = { Text(text = stringResource(id = currentTab.stringId)) },
                    icon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = currentTab.iconId),
                            contentDescription = stringResource(id = currentTab.stringId)
                        )
                    }
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxWidth(),
                state = pagerState
            ) { pageIndex ->
                Column {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp),
                        textAlign = TextAlign.Center,
                        text = state.updateTimeSec.toString(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        state = lazyListState
                    ) {
                        when (pageIndex) {
                            FlyType.DEPARTURE.ordinal -> {
                                items(state.airPortFlyDepartureItems) { airPortFly ->
                                    AirPortFlyItem(
                                        airPortFly = airPortFly
                                    )
                                }
                            }
                            FlyType.ARRIVAL.ordinal -> {
                                items(state.airPortFlyArrivalItems) { airPortFly ->
                                    AirPortFlyItem(
                                        airPortFly = airPortFly
                                    )
                                }
                            }
                        }
                    }
                }
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (state.error.isNotBlank()) {
                viewModel.cleanData()
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AirPortFlyScreenPreview() {
    AirPortFlyScreen()
}