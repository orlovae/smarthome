package ru.alexandrorlov.smarthome.data

import kotlinx.coroutines.flow.Flow
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.model.ui.DoorUi

interface Repository {
    suspend fun getAllCameraUi(): Flow<CameraUi>
    suspend fun getAllDoorUi(): Flow<DoorUi>
}