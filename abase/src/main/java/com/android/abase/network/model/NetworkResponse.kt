package com.android.abase.network.model

data class NetworkResponse<T>(
    val errorCode: Int,
    val errorMsg: String,
    val data: T,
    var token: String=""
) : BaseResponse<T>() {
    override fun isSuccess() = errorCode == 0

    override fun getResponseCode() = errorCode

    override fun getResponseMsg() = errorMsg

    override fun getAuthToken() = token

    override fun getResponseData() = data
}