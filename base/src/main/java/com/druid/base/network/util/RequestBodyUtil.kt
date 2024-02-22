package com.druid.base.network.util

import okhttp3.MediaType
import okhttp3.RequestBody

object RequestBodyUtil {
    fun getBody(jsonStr:String): RequestBody {
      return RequestBody.create(MediaType.parse("application/json"), jsonStr)
    }
}