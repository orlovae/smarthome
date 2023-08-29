package ru.alexandrorlov.smarthome.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import ru.alexandrorlov.smarthome.data.RepositoryCamera
import ru.alexandrorlov.smarthome.data.RepositoryCameraImpl
import ru.alexandrorlov.smarthome.data.local.DatabaseCamera
import ru.alexandrorlov.smarthome.data.local.RepositoryLocalCameraImpl
import ru.alexandrorlov.smarthome.data.remote.ApiCamera
import ru.alexandrorlov.smarthome.data.remote.RepositoryRemoteCameraImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryCameraModule {
    @Provides
    @Singleton
    fun provideRepositoryCamera(remote: ApiCamera, local: DatabaseCamera): RepositoryCamera =
        RepositoryCameraImpl(
            remote = remote,
            local = local
        )

    @Provides
    @Singleton
    fun provideDatabaseCamera(): DatabaseCamera = RepositoryLocalCameraImpl(
        database = RealmModule().providesRealmDatabase()
    )

    @Provides
    @Singleton
    fun provideApiDoor(client: HttpClient): ApiCamera = RepositoryRemoteCameraImpl(
        client = client
    )
}