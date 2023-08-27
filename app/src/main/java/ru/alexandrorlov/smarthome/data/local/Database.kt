package ru.alexandrorlov.smarthome.data.local

import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity

interface Database {
    suspend fun addCameraEntity(cameraEntity: CameraEntity)
    suspend fun addDoorEntity(doorEntity: DoorEntity)
    suspend fun getAllCameraEntity(): List<CameraEntity>
    suspend fun getAllDoorEntity(): List<DoorEntity>
    suspend fun clearCameraEntity()
    suspend fun clearDoorEntity()
}