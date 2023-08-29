package ru.alexandrorlov.smarthome.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import ru.alexandrorlov.smarthome.model.entity.CameraEntity
import ru.alexandrorlov.smarthome.model.entity.DoorEntity
import ru.alexandrorlov.smarthome.model.entity.RoomCamera
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RealmModule {

    @Provides
    @Singleton
    fun providesRealmDatabase(): Realm {
        val configuration =
            RealmConfiguration.create(
                schema = setOf(
                    CameraEntity::class,
                    RoomCamera::class,
                    DoorEntity::class
                )
            )
        return Realm.open(configuration)
    }
}