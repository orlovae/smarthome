package ru.alexandrorlov.smarthome.data.local

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity

class RepositoryLocalImpl constructor(private val database: Realm) : Database {

    override suspend fun addCameraEntity(cameraEntity: CameraEntity) {
        database.writeBlocking {
            copyToRealm(cameraEntity)
        }
    }

    override suspend fun addDoorEntity(doorEntity: DoorEntity) {
        database.writeBlocking {
            copyToRealm(doorEntity)
        }
    }

    override suspend fun getAllCameraEntity(): List<CameraEntity> {
        return database.query<CameraEntity>().find()
    }

    override suspend fun getAllDoorEntity(): List<DoorEntity> {
        return database.query<DoorEntity>().find()
    }

    override suspend fun clearCameraEntity() {
        TODO("Not yet implemented")
    }

    override suspend fun clearDoorEntity() {
        TODO("Not yet implemented")
    }
}