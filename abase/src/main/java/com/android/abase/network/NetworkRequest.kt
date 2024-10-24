package com.android.abase.network

import androidx.lifecycle.MutableLiveData
import com.android.abase.R
import com.android.abase.app.appContext
import com.android.abase.ext.util.loge
import com.android.abase.state.ResultState
import com.android.abase.state.paresException
import com.android.abase.state.paresResult
import com.android.abase.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 回调未处理，结果已封装
 */
fun <T> CoroutineScope.requestResult(
    block: suspend () -> com.android.abase.network.model.BaseResponse<T>,
    resultState: MutableLiveData<ResultState<T>>,
    isShowDialog: Boolean = false,
    loadingMessage: String = appContext.getString(R.string.loading)
): Job {
    return launch {
        runCatching {
            if (isShowDialog) resultState.value = ResultState.onAppLoading(loadingMessage)
            block()
        }.onSuccess {
            resultState.paresResult(it)
        }.onFailure {
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            resultState.paresException(it)
        }
    }
}

/**
 * 回调已处理，结果已封装
 */
fun <T> CoroutineScope.requestResultStatus(
    block: suspend () -> com.android.abase.network.model.BaseResponse<T>,
    success: (T) -> Unit,
    error: (com.android.abase.network.model.AppException) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingStatus: BaseViewModel.UiLoadingStatus?=null,
    loadingMessage: String = appContext.getString(R.string.loading)
): Job {
    return launch {
        runCatching {
            if (isShowDialog) {
                loadingStatus?.let {
                    it.showDialog.postValue(loadingMessage)
                }
            }
            //请求体
            block()
        }.onSuccess {
            //网络请求成功 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            runCatching {
                //校验请求结果码是否正确，不正确会抛出异常走下面的onFailure
                executeResponse(it) { t ->
                    success(t)
                }
            }.onFailure { e ->
                //打印错误消息
                e.message?.loge()
                //打印错误栈信息
                e.printStackTrace()
                //失败回调
                error(com.android.abase.network.except.ExceptionHandle.handleException(e))
            }
        }.onFailure {
            //网络请求异常 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            //打印错误消息
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            //失败回调
            error(com.android.abase.network.except.ExceptionHandle.handleException(it))
        }
    }
}

suspend fun <T> executeResponse(
    response: com.android.abase.network.model.BaseResponse<T>,
    success: suspend CoroutineScope.(T) -> Unit
) {
    coroutineScope {
//        when {
//            response.isSuccess() -> {
        success(response.getResponseData())
//            }
//            else -> {
//                throw AppException(
//                    response.getResponseCode(),
//                    response.getResponseMsg(),
//                    response.getResponseMsg()
//                )
//            }
//        }
    }
}

/**
 * 回调已处理，结果不封装
 */
fun <T> CoroutineScope.requestStatus(
    block: suspend () -> com.android.abase.network.model.BaseResponse<T>,
    success: (com.android.abase.network.model.BaseResponse<T>) -> Unit,
    error: (com.android.abase.network.model.AppException) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingStatus: BaseViewModel.UiLoadingStatus? = null,
    loadingMessage: String = appContext.getString(R.string.loading)
): Job {
    return launch {
        runCatching {
            if (isShowDialog) {
                loadingStatus?.let {
                    it.showDialog.postValue(loadingMessage)
                }
            }
            //请求体
            block()
        }.onSuccess {
            //网络请求成功 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            success(it)
        }.onFailure {
            //网络请求异常 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            //打印错误消息
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            //失败回调
            error(com.android.abase.network.except.ExceptionHandle.handleException(it))
        }
    }
}

/**
 * 通用请求 回调未处理，结果不封装
 */
fun <T> CoroutineScope.requestCommon(
    block: suspend () -> T,
    success: (T) -> Unit,
    error: (Throwable) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingStatus: BaseViewModel.UiLoadingStatus?,
    loadingMessage: String = appContext.getString(R.string.loading)
): Job {
    return launch {
        runCatching {
            if (isShowDialog) {
                loadingStatus?.let { loading ->
                    loading.showDialog.postValue(loadingMessage)
                }
            }
            //请求体
            block()
        }.onSuccess {
            //DB请求成功 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            success(it)
        }.onFailure {
            //DB请求异常 关闭弹窗
            loadingStatus?.let { loading ->
                loading.dismissDialog.postValue(false)
            }
            //打印错误消息
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            //失败回调
//            error(ExceptionHandle.handleException(it))
            error(it)
        }
    }
}

/**
 *  耗时任务
 * @param block 操作耗时操作任务
 * @param success 成功回调
 * @param error 失败回调 可不给
 */
fun <T> CoroutineScope.background(
    block: () -> T,
    success: (T) -> Unit,
    error: (Throwable) -> Unit = {}
) {
    launch {
        kotlin.runCatching {
            withContext(Dispatchers.IO) {
                block()
            }
        }.onSuccess {
            success(it)
        }.onFailure {
            error(it)
        }
    }
}