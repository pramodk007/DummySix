package com.example.dummysix.di

import android.content.Context
import androidx.room.Room
import com.example.dummysix.data.local.dao.FactDAO
import com.example.dummysix.data.local.database.FactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): FactDatabase {
        return Room.databaseBuilder(
            context,
            FactDatabase::class.java, "Fact.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFactDao(database: FactDatabase): FactDAO {
        return database.factDAO()
    }
}
