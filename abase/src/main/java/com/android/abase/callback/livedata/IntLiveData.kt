package com.android.abase.callback.livedata

import androidx.lifecycle.MutableLiveData

/**
 * 自定义的int类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class IntLiveData : MutableLiveData<Int>() {

    override fun getValue(): Int {
        return super.getValue() ?: 0
    }
}