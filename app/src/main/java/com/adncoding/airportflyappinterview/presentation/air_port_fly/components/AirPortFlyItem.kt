package com.adncoding.airportflyappinterview.presentation.air_port_fly.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adncoding.airportflyappinterview.domain.model.AirPortFly

/**
 * Created by AidenChang 2024/03/05
 */
@Composable
fun AirPortFlyItem(
    airPortFly: AirPortFly
) {
    Card(
        modifier = Modifier
            .padding(
                start = 16.dp,
                top = 0.dp,
                end = 16.dp,
                bottom = 16.dp
            ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Box {
            FlightLeftTag(
                modifier = Modifier
                    .align(Alignment.TopStart),
                text = airPortFly.flightNumber
            )
            FlightRightTag(
                modifier = Modifier
                .align(Alignment.TopEnd),
                text = airPortFly.remark
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 24.dp,
                        bottom = 20.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "${airPortFly.departureAirportID} → ${airPortFly.arrivalAirportID}",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${airPortFly.scheduleTime} 預計時間")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "${airPortFly.actualTime} 實際時間")
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = airPortFly.departureAirport)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = airPortFly.arrivalAirport)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "航廈/登機門 ${airPortFly.terminal}/${airPortFly.gate}")
                }
            }
        }

    }
}

@Preview
@Composable
private fun AirPortFlyItemPreview() {
    AirPortFlyItem(
        AirPortFly(
            flyType = "A",
            airlineID = "JX",
            airline = "星宇航空",
            flightNumber = "786",
            departureAirportID = "MNL",
            departureAirport = "馬尼拉機場",
            arrivalAirportID = "TPE",
            arrivalAirport = "臺北桃園國際機場",
            scheduleTime = "00:10",
            actualTime = "00:02",
            estimatedTime = "00:02",
            remark = "已到ARRIVED",
            terminal = "1",
            gate = "A9",
            updateTime = "2023-05-23 11:00:28"
        )
    )
}