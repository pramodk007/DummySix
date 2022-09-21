package com.example.dummysix.data.remote.remoteDataSource

import com.example.dummysix.common.network.fold
import com.example.dummysix.common.network.makeSafeRequest
import com.example.dummysix.data.remote.api.FactApiService
import com.example.dummysix.data.remote.response.FactModelDTO
import com.example.dummysix.common.network.ApiResult
import javax.inject.Inject

class FactRemoteDataSourceImpl @Inject constructor(
    private val apiService: FactApiService
) : FactRemoteDataSource {

    override suspend fun getFacts():ApiResult<FactModelDTO>{
        val result = makeSafeRequest { apiService.getFacts() }

        return result.fold(
            onSuccess = {
                ApiResult.Success(it)
            },
            onError = { code, message ->
                ApiResult.Error(code, message)
            },
            onException = { exception ->
                ApiResult.Exception(exception)
            }
        )
    }
}