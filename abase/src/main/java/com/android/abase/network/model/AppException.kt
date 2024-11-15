package com.android.abase.network.model


/**
 * 自定义错误信息异常
 */
class AppException : Exception {
    var errorMsg: String //错误消息
    var errCode: Int = 0 //错误码
    var rspCode: Int = 0 //服务器返回码
    var errorLog: String? //错误日志
    var throwable: Throwable? = null

    constructor(
        errCode: Int,
        error: String? = "",
        errorLog: String? = "",
        throwable: Throwable? = null
    ) : super(error) {
        this.errorMsg = error ?: "请求失败，请稍后再试"
        this.errCode = errCode
        this.rspCode = rspCode
        this.errorLog = errorLog ?: this.errorMsg
        this.throwable = throwable
    }

    constructor(error: com.android.abase.network.except.Error, e: Throwable?) {
        errCode = error.getKey()
        errorMsg = error.getValue()
        errorLog = e?.message
        throwable = e
    }
}