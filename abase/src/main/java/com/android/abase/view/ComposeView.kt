package com.android.abase.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import com.android.abase.ext.inflateBindingWithGeneric
import com.android.abase.viewmodel.BaseViewModel

abstract class ComposeView<VM : BaseViewModel, DB : ViewDataBinding>(
    context: Context?,
    attrs: AttributeSet?
) : BaseComposeView<VM>(context, attrs) {

    lateinit var mDatabind: DB

    override fun initView() {
        val inflater = LayoutInflater.from(context)
        mDatabind = inflateBindingWithGeneric(inflater)
        bindData()
    }

    abstract fun bindData()
    abstract fun createObserver()
}