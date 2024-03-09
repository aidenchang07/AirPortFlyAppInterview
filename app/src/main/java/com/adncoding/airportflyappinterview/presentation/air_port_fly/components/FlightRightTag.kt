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
fun FlightRightTag(
    modifier: Modifier = Modifier,
    text: String
) {
    val customShape = GenericShape { size, _ ->
        val cornerSize = 30.dp.value // 假设圆角大小为 16dp
        moveTo(0f, 0f)
        lineTo(size.width - cornerSize, 0f)
        quadraticBezierTo(size.width, 0f, size.width, cornerSize)
        lineTo(size.width, size.height)
        lineTo(cornerSize, size.height)
        quadraticBezierTo(0f, size.height, 0f, size.height - cornerSize)
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
private fun FlightRightTagPreview() {
    FlightLeftTag(
        modifier = Modifier,
        text = "已到ARRIVED"
    )
}