package com.example.dummysix.data.repository

import com.example.dummysix.common.network.ApiResult
import com.example.dummysix.data.remote.remoteDataSource.FactRemoteDataSource
import com.example.dummysix.data.remote.response.FactModelDTO
import com.example.dummysix.domain.repository.FactRepository
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val factRemoteDataSource: FactRemoteDataSource
) : FactRepository {
    override suspend fun getFacts(): ApiResult<FactModelDTO> {
        return factRemoteDataSource.getFacts()
    }
}