package ru.alexandrorlov.smarthome.model

import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity
import ru.alexandrorlov.smarthome.model.remote.camera.CameraRemote
import ru.alexandrorlov.smarthome.model.remote.door.DoorRemote
import ru.alexandrorlov.smarthome.model.ui.CameraUi
import ru.alexandrorlov.smarthome.model.ui.DoorUi

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

fun CameraEntity.toCameraUi(): CameraUi {
    return CameraUi(
        id = this.id,
        name = this.name,
        snapshotURL = this.snapshotURL,
        room = this.room,
        favorites = this.favorites,
        rec = this.rec
    )
}

fun DoorEntity.toDoorUi(): DoorUi {
    return DoorUi(
        id = this.id,
        name = this.name,
        room = this.room,
        favorites = this.favorites,
        snapshotURL = this.snapshotURL
    )
}