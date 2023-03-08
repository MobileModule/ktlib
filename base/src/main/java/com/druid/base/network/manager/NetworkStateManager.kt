package com.druid.base.network.manager

import com.druid.base.callback.livedata.event.EventLiveData

class NetworkStateManager private constructor(){
    var mNetworkStateCallback= EventLiveData<NetState>()
    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }
}