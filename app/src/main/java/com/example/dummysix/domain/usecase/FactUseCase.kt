package com.example.dummysix.domain.usecase

import com.example.dummysix.common.network.ApiResult
import com.example.dummysix.data.remote.response.FactModelDTO

interface FactUseCase {
    suspend fun getFacts(): ApiResult<FactModelDTO>
}