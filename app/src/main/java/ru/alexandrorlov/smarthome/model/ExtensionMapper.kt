package ru.alexandrorlov.smarthome.model

import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity
import ru.alexandrorlov.smarthome.model.remote.camera.CameraRemote
import ru.alexandrorlov.smarthome.model.remote.door.DoorRemote

fun CameraRemote.toRealmCamera(): CameraEntity {
    return CameraEntity().apply {
        id = this@toRealmCamera.id
        name = this@toRealmCamera.name
        snapshotURL = this@toRealmCamera.snapshotURL
        room = this@toRealmCamera.room
        favorites = this@toRealmCamera.favorites
        rec = this@toRealmCamera.rec
    }
}

fun DoorRemote.toRealmDoor(): DoorEntity {
    return DoorEntity().apply {
        id = this@toRealmDoor.id
        name = this@toRealmDoor.name
        room = this@toRealmDoor.room
        favorites = this@toRealmDoor.favorites
        snapshotURL = this@toRealmDoor.snapshot
    }
}