package ru.alexandrorlov.smarthome.ui.component.card.door

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.padding_normal

@Composable
fun CardItemBottomDoor(
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
        Spacer(modifier = Modifier)
        Icon(
            painter = painterResource(id = R.drawable.look_on),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemBottomDoorPreview() {
    val name = "Camera 1"
    val modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .background(Color.LightGray)
    CardItemBottomDoor(
        name = name,
        modifier = modifier
    )
}