package com.android.abase.network.interceptor

import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class MyResponseInterceptor(
    private val tokenHeader: String,
    private val responseCodeInterceptor: (Int) -> Unit = {}
) : Interceptor {

    val gson: Gson by lazy { Gson() }

    private fun getHttpOk(status: Int): Boolean {
        return status in 200..304
    }

    fun intercept111(chain: Interceptor.Chain): Response {
        //
        val response = chain.proceed(chain.request())
        var code = response.code
        responseCodeInterceptor.invoke(code)
        val mediaType = "application/json; charset=utf-8".toMediaType()
        var errorCode = -1
        if (getHttpOk(code)) {
            errorCode = 0
        }
        //包装基类-统一处理
        val jsonObject = JsonObject()
        jsonObject.addProperty("errorCode", errorCode)
        jsonObject.addProperty("errorMsg", "")

        if (response.body == null) {
            jsonObject.addProperty("data", "")
        } else {
            val body = response.body!!.string()
            if (body.isNotEmpty()) {
                jsonObject.addProperty("data", body)
            } else {
                jsonObject.addProperty("data", "")
            }
        }

        val headers = response.headers.toMultimap()
        if (tokenHeader.isNotEmpty()) {
            if (headers.containsKey(tokenHeader)) {
                val token = headers[tokenHeader]
                if (token != null) {
                    jsonObject.addProperty("token", token[0])
                }
            }
        }

        //
        val newBody = gson.toJson(jsonObject)
        //处理当前服务器的code不规范
        if (code == 204 || code == 201) {
            code = 200
        }
        val responseBody = newBody.toResponseBody(mediaType)
        return response.newBuilder().body(responseBody).code(code).build()
    }

    @kotlin.jvm.Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        var code = response.code
        responseCodeInterceptor.invoke(code)

        val mediaType = "application/json; charset=utf-8".toMediaType()
        val errorCode = if (getHttpOk(code)) 0 else -1

        // 构建响应 JSON 对象
        val jsonObject = JsonObject().apply {
            addProperty("errorCode", errorCode)
            addProperty("errorMsg", "")

            val bodyContent = response.body?.string().takeIf { !it.isNullOrEmpty() } ?: ""
            addProperty("data", bodyContent)

            val headers = response.headers.toMultimap()
            headers[tokenHeader]?.firstOrNull()?.let { token ->
                addProperty("token", token)
            }
        }

        // 构建新的响应体
        val newBody = gson.toJson(jsonObject).toResponseBody(mediaType)
        val adjustedCode = if (code == 204 || code == 201) 200 else code

        return response.newBuilder()
            .body(newBody)
            .code(adjustedCode)
            .build()
    }

}