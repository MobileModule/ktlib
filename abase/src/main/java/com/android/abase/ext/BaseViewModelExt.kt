package com.android.abase.ext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.abase.activity.BaseVMActivity
import com.android.abase.ext.util.loge
import com.android.abase.fragment.BaseVMFragment
import com.android.abase.network.AppException
import com.android.abase.network.BaseResponse
import com.android.abase.network.ExceptionHandle
import com.android.abase.state.ResultState
import com.android.abase.state.paresException
import com.android.abase.state.paresResult
import com.android.abase.viewmodel.BaseViewModel
import kotlinx.coroutines.*

/**
 * BaseViewModel请求协程封装
 */

fun <T> BaseVMActivity<*>.parseState(
    resultState: ResultState<T>,
    onSuccess: (T) -> Unit,
    onError: ((AppException) -> Unit)? = null,
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
    onSuccess: (T) -> Unit,
    onError: ((AppException) -> Unit)? = null,
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

fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    resultState: MutableLiveData<ResultState<T>>,
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    return viewModelScope.launch {
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

fun <T> BaseViewModel.requestNoCheck(
    block: suspend () -> T,
    resultState: MutableLiveData<ResultState<T>>,
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (isShowDialog) resultState.value = ResultState.onAppLoading(loadingMessage)
            //请求体
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

fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    success: (T) -> Unit,
    error: (AppException) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    return viewModelScope.launch {
        runCatching {
            if (isShowDialog) loadingChange.showDialog.postValue(loadingMessage)
            //请求体
            block()
        }.onSuccess {
            //网络请求成功 关闭弹窗
            loadingChange.dismissDialog.postValue(false)
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
                error(ExceptionHandle.handleException(e))
            }
        }.onFailure {
            //网络请求异常 关闭弹窗
            loadingChange.dismissDialog.postValue(false)
            //打印错误消息
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            //失败回调
            error(ExceptionHandle.handleException(it))
        }
    }
}

fun <T> BaseViewModel.requestNoCheck(
    block: suspend () -> T,
    success: (T) -> Unit,
    error: (AppException) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    //如果需要弹窗 通知Activity/fragment弹窗
    if (isShowDialog) loadingChange.showDialog.postValue(loadingMessage)
    return viewModelScope.launch {
        runCatching {
            //请求体
            block()
        }.onSuccess {
            //网络请求成功 关闭弹窗
            loadingChange.dismissDialog.postValue(false)
            //成功回调
            success(it)
        }.onFailure {
            //网络请求异常 关闭弹窗
            loadingChange.dismissDialog.postValue(false)
            //打印错误消息
            it.message?.loge()
            //打印错误栈信息
            it.printStackTrace()
            //失败回调
            error(ExceptionHandle.handleException(it))
        }
    }
}


suspend fun <T> executeResponse(
    response: BaseResponse<T>,
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
 *  调用携程
 * @param block 操作耗时操作任务
 * @param success 成功回调
 * @param error 失败回调 可不给
 */
fun <T> BaseViewModel.launch(
    block: () -> T,
    success: (T) -> Unit,
    error: (Throwable) -> Unit = {}
) {
    viewModelScope.launch {
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
