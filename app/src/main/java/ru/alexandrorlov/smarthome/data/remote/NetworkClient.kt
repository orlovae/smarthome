package ru.alexandrorlov.smarthome.data.remote

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import ru.alexandrorlov.smarthome.config.RemoteConfig.BASE_HOST
import ru.alexandrorlov.smarthome.config.RemoteConfig.BASE_PATH


object NetworkClient {
    fun create(): ApiService {
        return RepositoryRemoteImpl(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(json = json)
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 15000L
                    connectTimeoutMillis = 15000L
                    var socketTimeoutMillis = 15000L
                }
                defaultRequest {
                    url {
                        protocol = URLProtocol.HTTP
                        host = BASE_HOST
                        path(BASE_PATH)
                    }
                }
            }
        )
    }

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = true
        encodeDefaults = false
        classDiscriminator = "#class"
    }
}