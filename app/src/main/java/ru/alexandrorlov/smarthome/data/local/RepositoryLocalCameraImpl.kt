package ru.alexandrorlov.smarthome.data.local

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import javax.inject.Inject

class RepositoryLocalCameraImpl @Inject constructor(
    private val database: Realm
) : DatabaseCamera {

    override suspend fun addCameraEntity(cameraEntity: CameraEntity) {
        database.writeBlocking {
            copyToRealm(cameraEntity)
        }
    }

    override suspend fun getAllCameraEntity(): List<CameraEntity> {
        return database.query<CameraEntity>().find()
    }

    override suspend fun clearCameraEntity() {
        database.write {
            val cameras: RealmResults<CameraEntity> = this.query<CameraEntity>().find()
            delete(cameras)
        }
    }
}