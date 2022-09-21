package com.example.dummysix.common.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

suspend fun <T : Any> makeSafeRequest(
    execute: suspend () -> Response<T>
): ApiResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response = execute()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                ApiResult.Success(body)
            } else {
                ApiResult.Error(code = response.code(), message = response.message())
            }
        } catch (e: Exception) {
            Timber.e(e)
            ApiResult.Exception(e)
        }
    }
}