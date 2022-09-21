package com.example.dummysix.di

import com.example.dummysix.data.repository.FactRepositoryImpl
import com.example.dummysix.domain.repository.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(factRepositoryImpl: FactRepositoryImpl): FactRepository
}