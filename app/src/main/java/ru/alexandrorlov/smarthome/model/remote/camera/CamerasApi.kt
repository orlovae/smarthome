package ru.alexandrorlov.smarthome.model.remote.camera


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CamerasApi(
    @SerialName("success")
    val success: Boolean?,
    @SerialName("data")
    val dataRemote: DataRemote?
)