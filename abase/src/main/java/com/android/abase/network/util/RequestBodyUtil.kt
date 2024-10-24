package com.android.abase.network.util

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody

object RequestBodyUtil {
    fun getBody(jsonStr:String): RequestBody {
      return RequestBody.create("application/json".toMediaTypeOrNull(), jsonStr)
    }
}