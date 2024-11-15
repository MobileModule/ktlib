package com.android.abase.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 自定义头部参数拦截器，传入heads
 */
class MyHeaderInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
//        builder.addHeader("User-Agent",UserAgentUtils.getCustomAgent())
//        if (DruidApp.mInstance.tokenValid()) {
//            builder.addHeader(HttpServer.TOKEN, DruidApp.mInstance.token()).build()
//        }
        return chain.proceed(builder.build())
    }

}