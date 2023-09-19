package ru.alexandrorlov.smarthome.ui.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.ui.component.card.CardItemBottomCamera
import ru.alexandrorlov.smarthome.ui.component.card.CardItemTopCamera
import ru.alexandrorlov.smarthome.ui.theme.backgroundItemSecondary
import ru.alexandrorlov.smarthome.ui.theme.mediumRadius

@Composable
fun CardItem(
    camera: CameraUi
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(mediumRadius)
    ) {
        Column(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
        ) {
            CardItemTopCamera(
                camera = camera,
                modifier = Modifier
                    .weight(0.75f)
            )
            CardItemBottomCamera(
                name = camera.name,
                modifier = Modifier
                    .weight(0.25f)
                    .fillMaxWidth()
                    .background(backgroundItemSecondary)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardItemPreview() {
    val camera = CameraUi(
        id = 1,
        name = "Camera 1",
        snapshotURL = "https://serverspace.ru/wp-content/uploads/2019/06/backup-i-snapshot.png",
        room = "FIRST",
        favorites = true,
        rec = true
    )
    CardItem(
        camera = camera,

        )
}