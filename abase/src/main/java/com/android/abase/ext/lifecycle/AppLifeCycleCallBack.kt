package com.android.abase.ext.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.android.abase.ext.util.logd


class AppLifeCycleCallBack : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        MyActivityManager.addActivity(activity)
        "onActivityCreated : ${activity.localClassName}".logd()
    }
    override fun onActivityStarted(activity: Activity) {
        "onActivityStarted : ${activity.localClassName}".logd()
    }

    override fun onActivityResumed(activity: Activity) {
        "onActivityResumed : ${activity.localClassName}".logd()
    }

    override fun onActivityPaused(activity: Activity) {
        "onActivityPaused : ${activity.localClassName}".logd()
    }


    override fun onActivityDestroyed(activity: Activity) {
        "onActivityDestroyed : ${activity.localClassName}".logd()
        MyActivityManager.finishActivity(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {
        "onActivityStopped : ${activity.localClassName}".logd()
    }


}