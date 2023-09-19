package ru.alexandrorlov.smarthome.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.background

@Composable
fun ErrorScreen(
    message: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Text(
            text = message,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            style = SHTypography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(
        message = "Что-то пошло не так..."
    )
}