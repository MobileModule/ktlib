package com.android.abase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.android.abase.ext.inflateBindingWithGeneric
import com.android.abase.fragment.BaseVMFragment
import com.android.abase.viewmodel.BaseViewModel

abstract class BaseVMDbFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVMFragment<VM>() {

    override fun layoutId() = 0

    private var _binding: DB? = null
    val mDatabind: DB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBindingWithGeneric(inflater, container, false)
        return mDatabind.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}