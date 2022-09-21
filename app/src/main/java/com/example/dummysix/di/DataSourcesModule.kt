package com.example.dummysix.di

import com.example.dummysix.data.local.localDataSource.FactLocalDataSource
import com.example.dummysix.data.local.localDataSource.FactLocalDataSourceImpl
import com.example.dummysix.data.remote.remoteDataSource.FactRemoteDataSource
import com.example.dummysix.data.remote.remoteDataSource.FactRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Binds
    abstract fun bindLocalDataSource(localDataSourceImpl: FactLocalDataSourceImpl): FactLocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: FactRemoteDataSourceImpl): FactRemoteDataSource
}