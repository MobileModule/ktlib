package com.android.abase.network

import com.android.abase.R
import com.android.abase.app.appContext

/**
 * 错误枚举类
 */
enum class Error (private val code: Int, private val err: String) {

    /**
     * 未知错误
     */
    UNKNOWN(1000, appContext.getString(R.string.http_failed_unknown)),

    /**
     * 解析错误
     */
    PARSE_ERROR(1001, appContext.getString(R.string.http_failed_parse_result)),

    /**
     * 网络错误
     */
    NETWORK_ERROR(1002, appContext.getString(R.string.http_failed_network_error)),

    /**
     * 服务器返回异常错误
     * 400 401 404 500等常见错误信息
     */
    SERVER_ERROR(1003, appContext.getString(R.string.http_failed_server_error)),

    /**
     * 证书出错
     */
    SSL_ERROR(1004, appContext.getString(R.string.http_failed_ssl_error)),

    /**
     * 连接超时
     */
    TIMEOUT_ERROR(1006, appContext.getString(R.string.http_failed_connect_timeout));

    fun getValue(): String {
        return err
    }

    fun getKey(): Int {
        return code
    }

}