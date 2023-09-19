package ru.alexandrorlov.smarthome.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.padding_normal

@Composable
fun CardItemBottomCamera(
    name: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = name,
            modifier = Modifier
                .padding(
                    start = padding_normal,
                    top = padding_normal,
                    bottom = padding_normal
                ),
            style = SHTypography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemBottomCameraPreview() {
    val name = "Camera 1"
    val modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .background(Color.LightGray)
    CardItemBottomCamera(
        name = name,
        modifier = modifier
    )
}