package com.android.abase.activity

import android.view.View
import androidx.viewbinding.ViewBinding
import com.android.abase.ext.inflateBindingWithGeneric
import com.android.abase.viewmodel.BaseViewModel

/**
 * ViewModel 和 ViewBinding 基类
 */
abstract class BaseVMVbActivity <VM : BaseViewModel, VB : ViewBinding> : BaseVMActivity<VM>() {

    override fun layoutId(): Int = 0

    lateinit var mViewBind: VB

    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mViewBind = inflateBindingWithGeneric(layoutInflater)
        return mViewBind.root

    }
}