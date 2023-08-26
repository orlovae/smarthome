package ru.alexandrorlov.smarthome.remote

import ru.alexandrorlov.smarthome.Result

interface ApiService {
    suspend fun getCameras(): Result<Any>
    suspend fun getDoors(): Result<Any>
}