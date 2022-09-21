package com.example.dummysix.domain.repository

import com.example.dummysix.common.network.ApiResult
import com.example.dummysix.data.remote.response.FactModelDTO

interface FactRepository {
    suspend fun getFacts(): ApiResult<FactModelDTO>
}