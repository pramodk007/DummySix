package com.example.dummysix.di

import com.example.dummysix.domain.usecase.FactUseCase
import com.example.dummysix.domain.usecase.FactUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindLocalDataSource(factUseCaseImpl: FactUseCaseImpl): FactUseCase

}