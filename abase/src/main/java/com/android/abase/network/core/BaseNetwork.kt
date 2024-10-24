package com.android.abase.network.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * 网络请求构建器基类
 */
abstract class BaseNetwork {
    fun <T> getApi(serviceClass: Class<T>, baseUrl: String=""): T {
        val fixedBaseUrl = ensureTrailingSlash(baseUrl)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(fixedBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
        return setRetrofitBuilder(retrofitBuilder).build().create(serviceClass)
    }

    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private fun ensureTrailingSlash(baseUrl: String): String {
        return if (baseUrl.endsWith("/")) {
            baseUrl
        } else {
            "$baseUrl/"
        }
    }

    /**
     * 实现重写父类的setHttpClientBuilder方法，
     * 在这里可以添加拦截器，可以对 OkHttpClient.Builder 做任意操作
     */
    abstract fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder


    /**
     * 实现重写父类的setRetrofitBuilder方法，
     * 在这里可以对Retrofit.Builder做任意操作，比如添加GSON解析器，Protocol
     */
    abstract fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder

    /**
     * 配置http
     */
    private val okHttpClient: OkHttpClient
        get() {
            var builder = RetrofitUrlManager.getInstance().with(OkHttpClient.Builder())
            builder = setHttpClientBuilder(builder)
            return builder.build()
        }
}