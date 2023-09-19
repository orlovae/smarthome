package ru.alexandrorlov.smarthome.model.ui

data class DoorUi(
    val id: Int,
    val name: String,
    val room: String,
    val favorites: Boolean,
    val snapshotURL: String?,
)
