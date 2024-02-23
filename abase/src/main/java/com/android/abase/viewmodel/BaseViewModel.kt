package com.android.abase.viewmodel

import androidx.lifecycle.ViewModel
import com.android.abase.callback.databind.BooleanObservableField
import com.android.abase.callback.livedata.event.EventLiveData

/**
 * ViewModel的基类 使用ViewModel类
 */
open class BaseViewModel : ViewModel() {
    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }

        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }

    var showLeftArrow = BooleanObservableField()
    var showRightText = BooleanObservableField()
    var showRightImage = BooleanObservableField()
}