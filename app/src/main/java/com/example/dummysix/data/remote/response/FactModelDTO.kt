package com.example.dummysix.data.remote.response

import com.example.dummysix.domain.model.FactModel

data class FactModelDTO(
    val fact: String?,
    val length: Int?,
) {
    fun toPresentation(): FactModel {
        return FactModel(
            fact = fact,
            length = length
        )
    }
}