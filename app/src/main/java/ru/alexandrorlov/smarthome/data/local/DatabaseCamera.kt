package ru.alexandrorlov.smarthome.data.local

import ru.alexandrorlov.smarthome.model.entity.CameraEntity

interface DatabaseCamera {
    suspend fun addCameraEntity(cameraEntity: CameraEntity)
    suspend fun getAllCameraEntity(): List<CameraEntity>
    suspend fun clearCameraEntity()
}