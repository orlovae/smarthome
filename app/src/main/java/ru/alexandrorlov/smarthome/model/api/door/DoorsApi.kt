package ru.alexandrorlov.smarthome.model.api.door


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DoorsApi(
    @SerialName("success")
    val success: Boolean?,
    @SerialName("data")
    val data: List<Data>?
)