package ru.alexandrorlov.smarthome.model.remote.camera

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataRemote(
    @SerialName("room")
    val room: List<String>,
    @SerialName("cameras")
    val cameraRemotes: List<CameraRemote>
)