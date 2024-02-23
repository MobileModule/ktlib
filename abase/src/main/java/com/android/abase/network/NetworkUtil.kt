package com.android.abase.network

import android.content.Context
import android.net.ConnectivityManager

object NetworkUtil {
    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager ?: return false
        val info = manager.activeNetworkInfo
        return null != info && info.isAvailable
    }
}