package ru.alexandrorlov.smarthome.data.local

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import ru.alexandrorlov.smarthome.model.entity.DoorEntity
import javax.inject.Inject

class RepositoryLocalDoorImpl @Inject constructor(
    private val database: Realm
) : DatabaseDoor {

    override suspend fun addDoorEntity(doorEntity: DoorEntity) {
        database.writeBlocking {
            copyToRealm(doorEntity)
        }
    }

    override suspend fun getAllDoorEntity(): List<DoorEntity> {
        return database.query<DoorEntity>().find()
    }

    override suspend fun clearDoorEntity() {
        database.write {
            val doors: RealmResults<DoorEntity> = this.query<DoorEntity>().find()
            delete(doors)
        }
    }
}