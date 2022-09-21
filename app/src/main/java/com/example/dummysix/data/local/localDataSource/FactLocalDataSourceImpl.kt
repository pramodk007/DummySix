package com.example.dummysix.data.local.localDataSource

import com.example.dummysix.data.local.dao.FactDAO
import com.example.dummysix.data.local.entity.FactEntity
import javax.inject.Inject

class FactLocalDataSourceImpl @Inject constructor(
    private val factDAO: FactDAO
) : FactLocalDataSource {
    override suspend fun insertFact(factEntity: FactEntity) {
        factDAO.insertFact(factEntity)
    }

    override suspend fun deleteFact(factEntity: FactEntity) {
        factDAO.deleteFact(factEntity)
    }

    override suspend fun getFactData(): FactEntity {
        return factDAO.getFactData()
    }

    override suspend fun clearFactData() {
        factDAO.clearFactData()
    }
}