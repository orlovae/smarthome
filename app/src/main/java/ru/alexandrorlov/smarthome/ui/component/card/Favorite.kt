package ru.alexandrorlov.smarthome.ui.component.card

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.ui.theme.sizeFavorites

@Composable
fun Favorite(
) {
    Icon(
        modifier = Modifier
            .size(sizeFavorites),
        painter = painterResource(id = R.drawable.star_2),
        contentDescription = "favorites",
        tint = Color.Unspecified
    )
}

@Preview(showBackground = true)
@Composable
fun FavoritePreview() {
    Favorite()
}