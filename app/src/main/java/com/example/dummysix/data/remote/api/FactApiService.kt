package com.example.dummysix.data.remote.api

import com.example.dummysix.data.remote.response.FactModelDTO
import retrofit2.Response
import retrofit2.http.GET

interface FactApiService {

    @GET("fact")
    suspend fun getFacts(): Response<FactModelDTO>

}