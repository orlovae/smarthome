package ru.alexandrorlov.smarthome.data.local

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity
import ru.alexandrorlov.smarthome.model.entity.RoomCamera

object Realm {
    private val realm: Realm by lazy {
        val configuration =
            RealmConfiguration.create(
                schema = setOf(
                    CameraEntity::class,
                    RoomCamera::class,
                    DoorEntity::class
                )
            )
        Realm.open(configuration)
    }

    fun getInstance(): Database {
        return RepositoryLocalImpl(realm)
    }
}