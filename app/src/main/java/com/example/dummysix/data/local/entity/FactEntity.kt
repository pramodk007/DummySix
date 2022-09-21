package com.example.dummysix.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FactEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val fact: String?,
    val length: Int?,
)
