package ru.alexandrorlov.smarthome.ui.component

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import ru.alexandrorlov.smarthome.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.background

@Composable
fun LoadingScreen(){
    val progressValue = 1f
    val infiniteTransition = rememberInfiniteTransition()

    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = progressValue,
        animationSpec = infiniteRepeatable(animation = tween(2000))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            progress = progressAnimationValue,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            strokeWidth = 10.dp
        )
        Text(
            text = stringResource(id = R.string.loading),
            modifier = Modifier
                .fillMaxWidth(),
            style = SHTypography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}