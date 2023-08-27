package ru.alexandrorlov.smarthome.model.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class DoorEntity : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var room: String? = null
    var favorites: Boolean = false
    var snapshotURL: String? = null
}