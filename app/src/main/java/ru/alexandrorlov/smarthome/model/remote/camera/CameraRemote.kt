package ru.alexandrorlov.smarthome.model.remote.camera

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CameraRemote(
    @SerialName("name")
    val name: String,
    @SerialName("snapshot")
    val snapshotURL: String,
    @SerialName("room")
    val room: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("favorites")
    val favorites: Boolean,
    @SerialName("rec")
    val rec: Boolean
)
