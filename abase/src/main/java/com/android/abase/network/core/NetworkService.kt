package com.android.abase.network.core

import com.android.abase.network.model.NetworkResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url

interface NetworkService {
    @GET
    suspend fun get(
        @Url url: String,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>

    @POST
    suspend fun post(
        @Url url: String,
        @Body body: Any,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>

    @PUT
    suspend fun put(
        @Url url: String,
        @Body body: Any,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>

    @PUT
    suspend fun put(
        @Url url: String,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>

    @DELETE
    suspend fun delete(
        @Url url: String,
        @Body body: Any?,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>

    @DELETE
    suspend fun delete(
        @Url url: String,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): NetworkResponse<String>
}