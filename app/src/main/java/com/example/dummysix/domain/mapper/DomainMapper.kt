package com.example.dummysix.domain.mapper

interface DomainMapper <E, D> {

    fun mapToDomain(entity: E) : D

    fun mapToEntity(domainModel: D) : E
}
