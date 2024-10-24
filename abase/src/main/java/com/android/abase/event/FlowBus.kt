package com.android.abase.event

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.concurrent.ConcurrentHashMap

object FlowBus {
    private val busMap = mutableMapOf<String, EventBus<*>>()
    private val busStickMap = mutableMapOf<String, StickEventBus<*>>()

    @Synchronized
    fun <T> with(key: String): EventBus<T> {
        var eventBus = busMap[key]
        if (eventBus == null) {
            eventBus = EventBus<T>(key)
            busMap[key] = eventBus
        }
        return eventBus as EventBus<T>
    }

    @Synchronized
    fun <T> withStick(key: String): StickEventBus<T> {
        var eventBus = busStickMap[key]
        if (eventBus == null) {
            eventBus = StickEventBus<T>(key)
            busStickMap[key] = eventBus
        }
        return eventBus as StickEventBus<T>
    }

    //真正实现类
    open class EventBus<T>(private val key: String) :
        DefaultLifecycleObserver {//LifecycleObserver {

        //私有对象用于发送消息
        private val _events: MutableSharedFlow<T> by lazy {
            obtainEvent()
        }

        //暴露的公有对象用于接收消息
        val events = _events.asSharedFlow()

        open fun obtainEvent(): MutableSharedFlow<T> =
            MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST)

        //主线程接收数据
        fun register(lifecycleOwner: LifecycleOwner, action: (t: T) -> Unit) {
            lifecycleOwner.lifecycle.addObserver(this)
            lifecycleOwner.lifecycleScope.launch {
                events.collect {
                    try {
                        action(it)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        Log.e("FlowBus", "FlowBus - Error:$e")
                    }
                }
            }
        }

        //协程中发送数据
        suspend fun post(event: T) {
            _events.emit(event)
        }

        //主线程发送数据
        fun post(scope: CoroutineScope, event: T) {
            scope.launch {
                _events.emit(event)
            }
        }

        //自动销毁
//        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//        fun onDestroy() {
//            Log.w("FlowBus", "FlowBus - 自动onDestroy")
//            val subscriptCount = _events.subscriptionCount.value
//            if (subscriptCount <= 0)
//                busMap.remove(key)
//        }

        //自动销毁
        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            Log.w("FlowBus", "FlowBus - 自动onDestroy")
            val subscriptCount = _events.subscriptionCount.value
            if (subscriptCount <= 0)
                busMap.remove(key)
        }


    }

    class StickEventBus<T>(key: String) : EventBus<T>(key) {
        override fun obtainEvent(): MutableSharedFlow<T> =
            MutableSharedFlow(1, 1, BufferOverflow.DROP_OLDEST)
    }
}

class EventFlow : ViewModel() {
    companion object {
        val global = EventFlow()


        inline fun emitString(eventName: String) {
            global.emit(String::class.java, eventName, eventName)
        }

        inline fun <reified T> emit(eventName: String, value: T) {
            global.emit(T::class.java, eventName, value)
        }

        inline fun <reified T> emit(value: T) {
            global.emit(T::class.java, "", value)
        }

        inline fun <reified T> observe(
            owner: LifecycleOwner,
            eventName: String = "",
            minState: Lifecycle.State = Lifecycle.State.STARTED,
            noinline observer: (T) -> Unit
        ) {
            global.observe(T::class.java, owner, eventName, minState, observer)
        }

        inline fun <reified T> observeLatest(
            owner: LifecycleOwner,
            eventName: String = "",
            minState: Lifecycle.State = Lifecycle.State.STARTED,
            noinline observer: (T) -> Unit
        ) {
            global.observeLatest(T::class.java, owner, eventName, minState, observer)
        }

        inline fun <reified T> observeForever(
            eventName: String = "",
            noinline observer: (T) -> Unit
        ) {
            global.observeForever(T::class.java, eventName, observer)
        }
    }

    private val bus by lazy { ConcurrentHashMap<String, MutableSharedFlow<*>>() }

    fun emitString(eventName: String) {
        emit(String::class.java, eventName, eventName)
    }

    inline fun <reified T> emit(eventName: String, value: T) {
        emit(T::class.java, eventName, value)
    }


    inline fun <reified T> emit(value: T) {
        emit(T::class.java, "", value)
    }

    inline fun <reified T> observe(
        owner: LifecycleOwner,
        eventName: String = "",
        minState: Lifecycle.State = Lifecycle.State.STARTED,
        noinline observer: (T) -> Unit
    ) {
        observe(T::class.java, owner, eventName, minState, observer)
    }

    inline fun <reified T> observeLatest(
        owner: LifecycleOwner,
        eventName: String = "",
        minState: Lifecycle.State = Lifecycle.State.STARTED,
        noinline observer: (T) -> Unit
    ) {
        observeLatest(T::class.java, owner, eventName, minState, observer)
    }

    inline fun <reified T> observeForever(eventName: String = "", noinline observer: (T) -> Unit) {
        observeForever(T::class.java, eventName, observer)
    }

    fun <T> emit(eventClazz: Class<T>, eventName: String, value: T) {
        val key = "$eventClazz:$eventName"
        viewModelScope.launch {
            (bus[key] as? MutableSharedFlow<T>)?.emit(value)
        }
    }

    fun <T> observe(
        eventClazz: Class<T>,
        owner: LifecycleOwner,
        eventName: String,
        minState: Lifecycle.State = Lifecycle.State.STARTED,
        action: (T) -> Unit
    ) {
        get<T>("$eventClazz:$eventName", owner).observeRepeat(owner, minState, action)
    }

    fun <T> observeLatest(
        eventClazz: Class<T>,
        owner: LifecycleOwner,
        eventName: String,
        minState: Lifecycle.State = Lifecycle.State.STARTED,
        action: (T) -> Unit
    ) {
        get<T>("$eventClazz:$eventName", owner).observeLatest(owner, minState, action)
    }

    fun <T> observeForever(eventClazz: Class<T>, eventName: String, observer: (T) -> Unit) {
        viewModelScope.launch {
            get<T>("$eventClazz:$eventName").collect {
                try {
                    observer(it)
                } catch (ex: Throwable) {
                    ex.printStackTrace()
                }
            }
        }
    }


    private fun <T> get(key: String, owner: LifecycleOwner? = null): Flow<T> {
        val flow = bus.getOrPut(key) {
            MutableSharedFlow<T>(
                0,
                1,
                BufferOverflow.DROP_OLDEST
            )
        } as MutableSharedFlow<T>

        owner?.lifecycle?.addObserver(LifecycleEventObserver { _, lifecycleEvent ->
            if (lifecycleEvent == Lifecycle.Event.ON_DESTROY) {
                if (flow.subscriptionCount.value <= 0) {
                    bus.remove(key)
                }
            }
        })

        return flow
    }
}