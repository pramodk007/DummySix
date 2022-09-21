package com.example.dummysix.domain.usecase

import com.example.dummysix.common.network.ApiResult
import com.example.dummysix.data.remote.response.FactModelDTO
import com.example.dummysix.domain.repository.FactRepository
import javax.inject.Inject

class FactUseCaseImpl @Inject constructor(private val factRepository: FactRepository):FactUseCase{
    override suspend fun getFacts(): ApiResult<FactModelDTO> {
        return factRepository.getFacts()
    }

}