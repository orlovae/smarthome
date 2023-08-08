package ru.alexandrorlov.surf_test.ui.list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import ru.alexandrorlov.surf_test.ui.theme.SurfTestTypography
import ru.alexandrorlov.surf_test.ui.theme.padding_main_logo
import ru.alexandrorlov.surf_test.ui.theme.padding_small
import ru.alexandrorlov.surf_test.ui.theme.radius_large

@Composable
internal fun CocktailCard(
    navController: NavController,
    painter: Painter,
    title: String,
    id: Int
) {
    val shape = RoundedCornerShape(radius_large)
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding_small)
            .clickable {
                navController.navigate("DetailScreen /$id")
            },
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.White,
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.Transparent,
                    shape = shape
                ),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape)
            )
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = padding_main_logo),
                maxLines = 1,
                style = SurfTestTypography.bodyLarge,
                overflow = TextOverflow.Visible,
                textAlign = TextAlign.Center
            )
        }
    }
}