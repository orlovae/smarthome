package ru.alexandrorlov.smarthome.model.entity

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CameraEntity : RealmObject {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var snapshotURL: String = ""
    var room: String? = null
    var favorites: Boolean = false
    var rec: Boolean = false
}