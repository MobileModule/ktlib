package com.android.abase.activity

import android.view.View
import androidx.databinding.ViewDataBinding
import com.android.abase.ext.inflateBindingWithGeneric
import com.android.abase.viewmodel.BaseViewModel

/**
 * ViewModel和DataBind 基类
 */
abstract class BaseVMDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMActivity<VM>(){
    override fun layoutId() = 0
    lateinit var mDatabind: DB
    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mDatabind = inflateBindingWithGeneric(layoutInflater)
        return mDatabind.root
    }
}