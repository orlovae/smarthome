package ru.alexandrorlov.smarthome.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import ru.alexandrorlov.smarthome.data.RepositoryDoor
import ru.alexandrorlov.smarthome.data.RepositoryDoorImpl
import ru.alexandrorlov.smarthome.data.local.DatabaseDoor
import ru.alexandrorlov.smarthome.data.local.RepositoryLocalDoorImpl
import ru.alexandrorlov.smarthome.data.remote.ApiDoor
import ru.alexandrorlov.smarthome.data.remote.RepositoryRemoteDoorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryDoorModule {

    @Provides
    @Singleton
    fun provideRepositoryDoor(remote: ApiDoor, local: DatabaseDoor): RepositoryDoor =
        RepositoryDoorImpl(
            remote = remote,
            local = local
        )

    @Provides
    @Singleton
    fun provideDatabaseDoor(): DatabaseDoor = RepositoryLocalDoorImpl(
        database = RealmModule().providesRealmDatabase()
    )

    @Provides
    @Singleton
    fun provideApiDoor(client: HttpClient): ApiDoor = RepositoryRemoteDoorImpl(
        client = client
    )
}