package ru.alexandrorlov.surf_test.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.alexandrorlov.surf_test.config.DataLocal
import ru.alexandrorlov.surf_test.data.RepositoryLocal
import ru.alexandrorlov.surf_test.data.local.LocalDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideLocalDataBase(@ApplicationContext context: Context): LocalDataBase {
        return Room.databaseBuilder(
            context,
            LocalDataBase::class.java,
            DataLocal.DATABASE_NAME
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideRepositoryLocal(dataBase: LocalDataBase): RepositoryLocal = RepositoryLocal(dataBase)
}