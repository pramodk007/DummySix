package com.example.dummysix.data.remote.remoteDataSource

import com.example.dummysix.common.network.ApiResult
import com.example.dummysix.data.remote.response.FactModelDTO
import retrofit2.Response

interface FactRemoteDataSource {
    suspend fun getFacts():ApiResult<FactModelDTO>
}