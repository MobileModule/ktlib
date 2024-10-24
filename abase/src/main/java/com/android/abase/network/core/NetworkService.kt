package com.android.abase.network.core

import com.android.abase.network.model.BaseResponse
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Url

interface NetworkService {
    @GET
    suspend fun <T : BaseResponse<String>> get(
        @Url url: String,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): T

    @POST
    suspend fun <T : BaseResponse<String>> post(
        @Url url: String,
        @Body body: JsonObject,
        @HeaderMap headers: Map<String, String> = mutableMapOf()
    ): T
}