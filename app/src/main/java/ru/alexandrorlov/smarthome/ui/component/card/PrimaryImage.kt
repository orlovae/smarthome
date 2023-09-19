package ru.alexandrorlov.smarthome.ui.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.RoundedCornersTransformation
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.ui.theme.padding_small

@Composable
fun PrimaryImage(
    name: String,
    url: String
) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .fillMaxWidth(),
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(Size.ORIGINAL)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
                transformations(RoundedCornersTransformation(0f))
            }).build(),
        loading = {
            CircularProgressIndicator(
                strokeWidth = padding_small
            )
        },
        error = {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_error),
                contentDescription = "error"
            )
        },
        contentScale = ContentScale.FillWidth,
        contentDescription = name,
    )
}

@Preview(showBackground = true)
@Composable
fun PrimaryImagePreview() {
    val name = "Camera 1"
    val url = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png"
    PrimaryImage(
        name = name,
        url = url
    )
}