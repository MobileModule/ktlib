package com.android.abase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel的基类 使用ViewModel类
 */
open class BaseViewModel : ViewModel() {
    val PAGE_LIMIT: Int = 40
    val loadingStatus: UiLoadingStatus by lazy { UiLoadingStatus() }

    inner class UiLoadingStatus {
        //显示加载框
        val showDialog by lazy { MutableLiveData<String>() }

        //隐藏
        val dismissDialog by lazy { MutableLiveData<Boolean>() }
    }
}