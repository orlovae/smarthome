package ru.alexandrorlov.smarthome.model.ui

data class CameraUi(
    val id: Int,
    val name: String,
    val snapshotURL: String,
    val room: String?,
    val favorites: Boolean,
    val rec: Boolean,
)
