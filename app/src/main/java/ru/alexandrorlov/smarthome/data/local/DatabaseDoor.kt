package ru.alexandrorlov.smarthome.data.local

import ru.alexandrorlov.smarthome.model.entity.DoorEntity

interface DatabaseDoor {

    suspend fun addDoorEntity(doorEntity: DoorEntity)
    suspend fun getAllDoorEntity(): List<DoorEntity>
    suspend fun clearDoorEntity()
}