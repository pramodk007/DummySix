package com.example.dummysix.data.local.dao

import androidx.room.*
import com.example.dummysix.data.local.entity.FactEntity

@Dao
interface FactDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(factEntity: FactEntity)

    @Delete
    suspend fun deleteFact(factEntity: FactEntity)

    @Query("SELECT * FROM FactEntity")
    suspend fun getFactData():FactEntity

    @Transaction
    @Query("DELETE FROM FactEntity")
    suspend fun clearFactData()

}