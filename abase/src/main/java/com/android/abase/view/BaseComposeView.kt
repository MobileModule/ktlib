package com.android.abase.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.android.abase.viewmodel.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseComposeView <VM : BaseViewModel> (context: Context?, attrs: AttributeSet?): LinearLayout(context, attrs){
    var mViewModel: VM
    init {
        mViewModel = createViewModel()
        initView()
    }

    abstract fun initView()

    private fun createViewModel(): VM {
        val viewModelStoreOwner = context as? ViewModelStoreOwner
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val actualTypeArguments = type.actualTypeArguments
            if (actualTypeArguments.isNotEmpty()) {
                val viewModelClass = actualTypeArguments[0] as Class<VM>
                return ViewModelProvider(viewModelStoreOwner!!).get(viewModelClass)
            }
        }
        throw IllegalStateException("Unable to determine ViewModel class")
    }

}