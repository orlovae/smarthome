package ru.alexandrorlov.smarthome.ui.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.ui.theme.SHTypography

@Composable
fun Record(
) {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .background(Color.Transparent)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.record),
            contentDescription = "",
            tint = Color.Unspecified
        )
        Text(
            text = stringResource(id = R.string.record),
            style = SHTypography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecordPreview() {
    Record()
}