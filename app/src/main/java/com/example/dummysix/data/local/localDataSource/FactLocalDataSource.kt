package com.example.dummysix.data.local.localDataSource

import androidx.room.*
import com.example.dummysix.data.local.entity.FactEntity

interface FactLocalDataSource {

    suspend fun insertFact(factEntity: FactEntity)

    suspend fun deleteFact(factEntity: FactEntity)

    suspend fun getFactData():FactEntity

    suspend fun clearFactData()
}