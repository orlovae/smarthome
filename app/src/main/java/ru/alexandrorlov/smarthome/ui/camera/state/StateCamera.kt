package ru.alexandrorlov.smarthome.ui.camera.state

import androidx.annotation.StringRes
import ru.alexandrorlov.smarthome.base.UiState
import ru.alexandrorlov.smarthome.model.ui.CameraUi

sealed class StateCamera : UiState {
    object Loading : StateCamera()
    data class Data(val cameraList: List<CameraUi>) : StateCamera()

    val data: Data?
        get() = this as? Data

    data class Error(@StringRes val idMessage: Int) : StateCamera()
}
