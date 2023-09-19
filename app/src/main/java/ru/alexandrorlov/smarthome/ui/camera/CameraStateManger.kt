package ru.alexandrorlov.smarthome.ui.camera

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.ui.camera.state.StateCamera
import ru.alexandrorlov.smarthome.ui.component.ErrorScreen
import ru.alexandrorlov.smarthome.ui.component.LoadingScreen

@Composable
fun CameraStateManger(
    viewModel: ViewModelCamera
) {
    val uiState by viewModel.uiState.collectAsState()
    when (uiState.stateCamera) {
        is StateCamera.Loading -> {
            LoadingScreen()
        }
        is StateCamera.Data -> {
            val cameraUiList = (uiState.stateCamera as StateCamera.Data).cameraList
            if (cameraUiList.isNotEmpty()) {
                CameraScreen(
                    cameraUiList = cameraUiList
                )
            } else {
                ErrorScreen(
                    message = stringResource(id = R.string.exception_Exception)
                )
            }
        }
        is StateCamera.Error -> {
            val idMessage = (uiState.stateCamera as StateCamera.Error).idMessage
            ErrorScreen(
                message = stringResource(id = idMessage)
            )
        }
    }
}