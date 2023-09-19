package ru.alexandrorlov.smarthome.ui.component.card.door

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.ui.component.card.Favorite
import ru.alexandrorlov.smarthome.ui.component.card.PlayButton
import ru.alexandrorlov.smarthome.ui.component.card.PrimaryImage
import ru.alexandrorlov.smarthome.ui.component.card.Record
import ru.alexandrorlov.smarthome.ui.theme.padding_medium
import ru.alexandrorlov.smarthome.ui.theme.padding_normal

@Composable
fun CardItemTopDoor(
    camera: CameraUi,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        PrimaryImage(
            name = camera.name,
            url = camera.snapshotURL
        )
        if (camera.rec) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(padding_normal)
            ) {
                Record()
            }
        }
        Box(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            PlayButton()
        }
        if (camera.favorites) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(padding_medium)
            ) {
                Favorite()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemTopDoorPreview() {
    val camera = CameraUi(
        id = 1,
        name = "Camera 1",
        snapshotURL = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
        room = "FIRST",
        favorites = false,
        rec = false
    )
    val modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color.LightGray)
    CardItemTopDoor(
        camera = camera,
        modifier = modifier
    )
}