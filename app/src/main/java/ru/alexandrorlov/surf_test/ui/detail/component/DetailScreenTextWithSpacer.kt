package ru.alexandrorlov.surf_test.ui.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.surf_test.ui.theme.SpacerGray

@Composable
internal fun DetailScreenTextWithSpacer(
    text: String
) {
    DetailScreenText(text = text)
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Spacer(
            modifier = Modifier
                .width(9.dp)
                .height(1.dp)
                .background(SpacerGray)
        )
    }
}