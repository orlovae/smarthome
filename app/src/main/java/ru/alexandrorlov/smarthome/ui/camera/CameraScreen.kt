package ru.alexandrorlov.smarthome.ui.camera

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.ui.theme.SHTypography
import ru.alexandrorlov.smarthome.ui.theme.backgroundItemPrimary
import ru.alexandrorlov.smarthome.ui.theme.padding_normal

@Composable
fun CameraScreen(
    cameraUiList: List<CameraUi>
) {
    val scrollStatePrimary = rememberLazyListState()
    val roomSet = cameraUiList.map {
        it.room
    }.toSet()

    val listCameraUiSortRoom = mutableListOf<List<CameraUi>>()
    roomSet.forEach { roomEntity ->
        listCameraUiSortRoom.add(
            cameraUiList.filter { it.room == roomEntity }
        )
    }

    LazyColumn(
        modifier = Modifier
            .background(backgroundItemPrimary)
            .padding(
                start = padding_normal,
                end = padding_normal
            ),
        state = scrollStatePrimary
    ) {
        listCameraUiSortRoom.forEach { listCamera ->
            item {
                Column() {
                    Text(
                        text = listCamera.first().room,
                        style = SHTypography.titleMedium,
                        modifier = Modifier.padding(
                            top = padding_normal,
                            bottom = padding_normal
                        )
                    )
                }
            }
            items(listCamera) { camera ->
                CardItem(camera = camera)
                Divider(
                    color = backgroundItemPrimary,
                    thickness = padding_normal
                )
            }
        }
    }
}