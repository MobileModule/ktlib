package com.android.abase.network.manager

import com.android.abase.callback.livedata.event.EventLiveData

class NetworkStateManager private constructor(){
    var mNetworkStateCallback= EventLiveData<NetState>()
    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}