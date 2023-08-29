package ru.alexandrorlov.smarthome.ui.camera.state

import ru.alexandrorlov.smarthome.base.UiState

data class StateCameraUi(
    val stateCamera: StateCamera = StateCamera.Loading
) : UiState