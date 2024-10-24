package com.android.abase.network.except

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 * 根据异常返回相关的错误信息工具类
 */
object ExceptionHandle {
    fun handleException(e: Throwable?): com.android.abase.network.model.AppException {
        var ex: com.android.abase.network.model.AppException
        e?.let {
            when (it) {
                is HttpException -> {
                    when (it.code()) {
                        400, 404, 500 -> {
                            ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.SERVER_ERROR, e)
                            ex.rspCode = it.code()
                            return ex
                        }

                        else -> {
                            ex =
                                com.android.abase.network.model.AppException(com.android.abase.network.except.Error.NETWORK_ERROR, e)
                            ex.rspCode = it.code()
                            return ex
                        }
                    }
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.NETWORK_ERROR, e)
                    ex.rspCode = it.code()
                    return ex
                }

                is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.PARSE_ERROR, e)
                    return ex
                }

                is ConnectException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.NETWORK_ERROR, e)
                    return ex
                }

                is javax.net.ssl.SSLException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.SSL_ERROR, e)
                    return ex
                }

                is ConnectTimeoutException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is java.net.SocketTimeoutException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is java.net.UnknownHostException -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is com.android.abase.network.model.AppException -> return it

                else -> {
                    ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.UNKNOWN, e)
                    return ex
                }
            }
        }
        ex = com.android.abase.network.model.AppException(com.android.abase.network.except.Error.UNKNOWN, e)
        return ex
    }
}