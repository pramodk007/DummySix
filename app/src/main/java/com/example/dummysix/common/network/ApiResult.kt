package com.example.dummysix.common.network

sealed class ApiResult<T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Error<T : Any>(val code: Int, val message: String?) : ApiResult<T>()
    class Exception<T : Any>(val exception: kotlin.Exception) : ApiResult<T>()
}

inline fun <R, T> ApiResult<T>.fold(
    onSuccess: (value: T) -> R,
    onError: (code: Int, message: String?) -> R,
    onException: (exception: Exception) -> R
): R = when (this) {
    is ApiResult.Success -> onSuccess(data)
    is ApiResult.Error -> onError(code, message)
    is ApiResult.Exception -> onException(exception)
}