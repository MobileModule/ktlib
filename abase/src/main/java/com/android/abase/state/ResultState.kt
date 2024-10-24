package com.android.abase.state

import androidx.lifecycle.MutableLiveData
import com.android.abase.activity.BaseVMActivity
import com.android.abase.fragment.BaseVMFragment
import com.android.abase.network.model.AppException
import com.android.abase.network.model.BaseResponse
import com.android.abase.network.except.ExceptionHandle

sealed class ResultState<out T> {
    companion object {
        fun <T> onAppSuccess(data: T): ResultState<T> = Success(data)
        fun <T> onAppLoading(loadingMessage: String): ResultState<T> = Loading(loadingMessage)
        fun <T> onAppError(error: com.android.abase.network.model.AppException): ResultState<T> = Error(error)
    }

    data class Loading(val loadingMessage: String) : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val error: com.android.abase.network.model.AppException) : ResultState<Nothing>()
}

/**
 * 处理返回值
 * @param result 请求结果
 */
fun <T> MutableLiveData<ResultState<T>>.paresResult(result: com.android.abase.network.model.BaseResponse<T>) {
    value = when {
        result.isSuccess() -> {
            ResultState.onAppSuccess(result.getResponseData())
        }
        else -> {
            ResultState.onAppError(
                com.android.abase.network.model.AppException(
                    result.getResponseCode(),
                    result.getResponseMsg()
                )
            )
        }
    }
}

/**
 * 不处理返回值 直接返回请求结果
 * @param result 请求结果
 */
fun <T> MutableLiveData<ResultState<T>>.paresResult(result: T) {
    value = ResultState.onAppSuccess(result)
}

/**
 * 异常转换异常处理
 */
fun <T> MutableLiveData<ResultState<T>>.paresException(e: Throwable) {
    this.value = ResultState.onAppError(com.android.abase.network.except.ExceptionHandle.handleException(e))
}


/**
 * BaseViewModel请求协程封装
 */
fun <T> BaseVMActivity<*>.parseState(
    resultState: ResultState<T>,
    onSuccess: (T) -> Unit,
    onError: ((com.android.abase.network.model.AppException) -> Unit)? = null,
    onLoading: (() -> Unit)? = null
) {
    when (resultState) {
        is ResultState.Loading -> {
            showLoading(resultState.loadingMessage)
            onLoading?.run { this }
        }

        is ResultState.Success -> {
            dismissLoading()
            onSuccess(resultState.data)
        }

        is ResultState.Error -> {
            dismissLoading()
            onError?.run { this(resultState.error) }
        }
    }
}

fun <T> BaseVMFragment<*>.parseState(
    resultState: ResultState<T>,
    onSuccess: (T?) -> Unit,
    onError: ((com.android.abase.network.model.AppException) -> Unit)? = null,
    onLoading: ((message: String) -> Unit)? = null
) {
    when (resultState) {
        is ResultState.Loading -> {
            if (onLoading == null) {
                showLoading(resultState.loadingMessage)
            } else {
                onLoading.invoke(resultState.loadingMessage)
            }
        }

        is ResultState.Success -> {
            dismissLoading()
            onSuccess(resultState.data)
        }

        is ResultState.Error -> {
            dismissLoading()
            onError?.run { this(resultState.error) }
        }
    }
}