package ru.alexandrorlov.smarthome.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.R

@Composable
fun PlayButton() {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.play_button_circle),
            contentDescription = "circle",
            tint = Color.Unspecified
        )
        Icon(
            painter = painterResource(id = R.drawable.play_button_play),
            contentDescription = "play",
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayButtonPreview(){
    PlayButton()
}