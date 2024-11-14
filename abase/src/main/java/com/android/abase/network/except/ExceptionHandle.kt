package com.android.abase.network.except

import android.net.ParseException
import com.android.abase.network.model.AppException
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
    fun handleException(e: Throwable?): AppException {
        var ex: AppException
        e?.let {
            when (it) {
                is HttpException -> {
                    when (it.code()) {
                        400, 404, 500 -> {
                            ex = AppException(Error.SERVER_ERROR, e)
                            ex.rspCode = it.code()
                            return ex
                        }

                        else -> {
                            ex = AppException(Error.NETWORK_ERROR, e)
                            ex.rspCode = it.code()
                            return ex
                        }
                    }
                    ex = AppException(Error.NETWORK_ERROR, e)
                    ex.rspCode = it.code()
                    return ex
                }

                is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                    ex = AppException(Error.PARSE_ERROR, e)
                    return ex
                }

                is ConnectException -> {
                    ex = AppException(Error.NETWORK_ERROR, e)
                    return ex
                }

                is javax.net.ssl.SSLException -> {
                    ex = AppException(Error.SSL_ERROR, e)
                    return ex
                }

                is ConnectTimeoutException -> {
                    ex = AppException(Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is java.net.SocketTimeoutException -> {
                    ex = AppException(Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is java.net.UnknownHostException -> {
                    ex = AppException(Error.TIMEOUT_ERROR, e)
                    return ex
                }

                is AppException -> return it

                else -> {
                    ex = AppException(Error.UNKNOWN, e)
                    return ex
                }
            }
        }
        ex = AppException(Error.UNKNOWN, e)
        return ex
    }
}