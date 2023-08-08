package ru.alexandrorlov.surf_test.ui.detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTypography
import ru.alexandrorlov.surf_test.ui.theme.padding_normal

@Composable
internal fun DetailScreenText(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(
                top = padding_normal,
                bottom = padding_normal
            ),
        style = SurfTestTypography.bodyMedium,
        textAlign = TextAlign.Center
    )
}