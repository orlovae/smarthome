package ru.alexandrorlov.smarthome.data.remote

import ru.alexandrorlov.smarthome.model.remote.camera.CameraRemote

interface ApiCamera {
    suspend fun getCameras(): List<CameraRemote>
}