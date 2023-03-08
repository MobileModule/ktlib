package com.druid.base.app

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.content.IntentFilter
import android.database.Cursor
import android.net.ConnectivityManager
import android.net.Uri
import androidx.lifecycle.ProcessLifecycleOwner
import com.druid.base.ext.lifecycle.KtxAppLifeObserver
import com.druid.base.ext.lifecycle.KtxLifeCycleCallBack
import com.druid.base.network.manager.NetworkStateReceive

val appContext: Application by lazy { Ktx.app }

class Ktx : ContentProvider() {
    companion object {
        lateinit var app: Application
        private var mNetworkStateReceive: NetworkStateReceive? = null
        var watchActivityLife = true
        var watchAppLife = true
    }

    override fun onCreate(): Boolean {
        val application = context!!.applicationContext as Application
        install(application)
        return true
    }

    private fun install(application: Application) {
        app = application
        mNetworkStateReceive = NetworkStateReceive()
        app.registerReceiver(
            mNetworkStateReceive,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )

        if (watchActivityLife) application.registerActivityLifecycleCallbacks(KtxLifeCycleCallBack())
        if (watchAppLife) ProcessLifecycleOwner.get().lifecycle.addObserver(KtxAppLifeObserver)
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun getType(uri: Uri): String? {
        TODO("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        TODO("Not yet implemented")
    }

}