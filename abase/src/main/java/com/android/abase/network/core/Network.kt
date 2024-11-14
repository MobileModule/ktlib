package com.android.abase.network.core

import com.android.abase.BuildConfig
import com.android.abase.app.appContext
import com.android.abase.ext.lifecycle.logging.LogInterceptor
import com.android.abase.network.interceptor.MyCacheInterceptor
import com.android.abase.network.interceptor.MyHeaderInterceptor
import com.android.abase.network.interceptor.MyResponseInterceptor
import com.android.abase.network.util.SSLSocketClient
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *  描述: 网络请求构建器，继承BaseNetwork 并实现setHttpClientBuilder/setRetrofitBuilder方法，
 *  在这里可以添加拦截器，设置构造器可以对Builder做任意操作
 */

//双重校验锁式-单例 封装NetworkService 方便直接快速调用简单的接口
val networkService: NetworkService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    Network.INSTANCE.getApi(NetworkService::class.java, Network.baseUrl)
}

class Network : BaseNetwork() {
    companion object {
        val INSTANCE: Network by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Network()
        }
        var tokenHeader = ""
        var baseUrl = ""
        var responseCodeInterceptor: (Int) -> Unit = {}
    }

    /**
     * 实现重写父类的setHttpClientBuilder方法，
     * 在这里可以添加拦截器，可以对 OkHttpClient.Builder 做任意操作
     */
    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        builder.apply {
            //设置缓存配置 缓存最大10M
//            cache(Cache(File(appContext.cacheDir, "druid_cache"), 10 * 1024 * 1024))
            //添加Cookies自动持久化
//            cookieJar(cookieJar)
            //示例：添加公共heads 注意要设置在日志拦截器之前，不然Log中会不显示head信息
//            addInterceptor(MyHeaderInterceptor())
            addInterceptor(MyResponseInterceptor(tokenHeader, responseCodeInterceptor))
            //添加缓存拦截器 可传入缓存天数，不传默认7天
            addInterceptor(MyCacheInterceptor())
            // 日志拦截器
            if (BuildConfig.DEBUG) {
                addInterceptor(LogInterceptor())
            }
            //
            sslSocketFactory(
                SSLSocketClient.TrustAll.createSSLSocketFactory(),
                SSLSocketClient.TrustAll.getX509TrustManager()
            )
            followRedirects(true)
            hostnameVerifier(SSLSocketClient.TrustAll.getHostnameVerifier())
            //超时时间 连接、读、写
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
        return builder
    }

    /**
     * 实现重写父类的setRetrofitBuilder方法，
     * 在这里可以对Retrofit.Builder做任意操作，比如添加GSON解析器，protobuf等
     */
    override fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder.apply {
            addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
    }


    val cookieJar: PersistentCookieJar by lazy {
        PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(appContext))
    }
}