package com.example.dummysix.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dummysix.data.local.dao.FactDAO
import com.example.dummysix.data.local.entity.FactEntity

@Database(
    entities = [FactEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FactDatabase: RoomDatabase() {
    abstract fun factDAO(): FactDAO
}