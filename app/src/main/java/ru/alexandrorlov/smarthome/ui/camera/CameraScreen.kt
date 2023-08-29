package ru.alexandrorlov.smarthome.ui.camera

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.ui.camera.state.StateCamera

@Composable
fun CameraScreen(
    viewModel: ViewModelCamera
) {
    val uiState by viewModel.uiState.collectAsState()
    var list = emptyList<CameraUi>()
    if (uiState.stateCamera is StateCamera.Data) {
        val data = uiState.stateCamera as StateCamera.Data
        list = data.cameraList
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(text = list.toString())
    }
}