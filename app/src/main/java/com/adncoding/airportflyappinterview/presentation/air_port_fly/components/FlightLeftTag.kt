package com.adncoding.airportflyappinterview.presentation.air_port_fly.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by AidenChang 2024/03/07
 */
@Composable
fun FlightLeftTag(
    modifier: Modifier = Modifier,
    text: String
) {
    val customShape = GenericShape { size, _ ->
        val cornerSize = 30.dp.value
        moveTo(cornerSize, 0f)
        quadraticBezierTo(0f, 0f, 0f, cornerSize)
        lineTo(0f, size.height)
        lineTo(size.width - cornerSize, size.height)
        quadraticBezierTo(size.width, size.height, size.width, size.height - cornerSize)
        lineTo(size.width, 0f)
        close()
    }
    Text(
        text = text,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .clip(customShape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        fontSize = 10.sp
    )
}

@Preview
@Composable
private fun FlightLeftTagPreview() {
    FlightLeftTag(
        modifier = Modifier,
        text = "101"
    )
}