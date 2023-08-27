package ru.alexandrorlov.smarthome.model.entity

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject

class RoomCamera : RealmObject {
    var rooms : RealmList<String> = realmListOf()
}