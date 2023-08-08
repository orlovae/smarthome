package ru.alexandrorlov.surf_test.ui.main.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTypography
import ru.alexandrorlov.surf_test.ui.theme.padding_normal

@Composable
internal fun Title(
    text: String
) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(
                bottom = padding_normal
            ),
        maxLines = 1,
        style = SurfTestTypography.titleLarge,
        overflow = TextOverflow.Visible,
        textAlign = TextAlign.Center
    )
}