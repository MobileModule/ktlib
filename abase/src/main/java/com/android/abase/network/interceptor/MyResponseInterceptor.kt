package com.android.abase.network.interceptor

import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.io.IOException

class MyResponseInterceptor(val tokenHeader: String) : Interceptor {

    val gson: Gson by lazy { Gson() }

    private fun getHttpOk(status: Int): Boolean {
        return status in 200..304
    }

    @kotlin.jvm.Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //
        val response = chain.proceed(chain.request())
        return if (response.body != null && response.body!!.contentType() != null) {
            val mediaType = "application/json; charset=utf-8".toMediaType()
            val body = response.body!!.string()
            var code = response.code
            var errorCode = -1
            if (getHttpOk(code)) {
                errorCode = 0
            }
            //包装基类-统一处理
            val jsonObject = JsonObject()
            jsonObject.addProperty("errorCode", errorCode)
            jsonObject.addProperty("errorMsg", "")
            if (body.isNotEmpty()) {
                jsonObject.addProperty("data", body)
            } else {
                jsonObject.addProperty("data", "")
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
            if (code == 204) {
                code = 200
            }
            val responseBody = newBody.toResponseBody(mediaType)
            response.newBuilder().body(responseBody).code(code).build()
        } else {
            response
        }
    }
}