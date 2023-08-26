package ru.alexandrorlov.smarthome.model.api.camera


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CamerasApi(
    @SerialName("success")
    val success: Boolean?,
    @SerialName("data")
    val data: Data?
)