package ru.alexandrorlov.smarthome.model.api.camera

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("room")
    val room: List<String>,
    @SerialName("cameras")
    val cameras: List<Camera>
)