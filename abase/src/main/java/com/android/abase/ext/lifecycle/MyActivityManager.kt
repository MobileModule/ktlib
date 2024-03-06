package com.android.abase.ext.lifecycle

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.Stack

object MyActivityManager {
    val TAG = MyActivityManager::class.java.name
    private val activityStack = Stack<Activity>()

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }


    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    val currentActivity: Activity?
        get() =
            if (activityStack.isEmpty()) null
            else activityStack.lastElement()


    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    fun finishActivity() {
        val activity = activityStack.lastElement()
        finishActivity(activity)
    }

    /**
     * 结束指定的Activity
     */
    fun finishActivity(activity: Activity) {
        if (activity != null) {
            activityStack.remove(activity)
            if (!activity.isDestroyed) {
                activity.finish()
            }
        }
    }

    fun finishActivity(clazz: Class<*>) {
        for (activity in activityStack) {
            if (activity.javaClass == clazz) {
                activityStack.remove(activity)
                finishActivity(activity)
                return
            }
        }
    }


    /**
     * 结束指定类名的Activity
     */
    fun existsActivity(cls: Class<*>): Boolean {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                return true
            }
        }
        return false
    }

    fun getExistsActivity(cls: Class<*>): Activity? {
        for (activity in activityStack) {
            if (activity.javaClass == cls) {
                return activity
            }
        }
        return null
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        if (activityStack == null) return
        var i = 0
        val size = activityStack.size
        while (i < size) {
            if (null != activityStack[i]) {
                if (!activityStack[i].isDestroyed) {
                    activityStack[i].finish()
                }
            }
            i++
        }
        if (activityStack.size > 0) {
            activityStack.clear()
        }
    }

    fun finishNotSpecifiedActivity(cls: Class<*>) {
        var i = 0
        val size = activityStack.size
        while (i < size) {
            if (null != activityStack[i] && activityStack[i].javaClass != cls) {
                activityStack[i].finish()
            }
            i++
        }
        activityStack.clear()
    }

    fun activityCounts(): Int {
        return activityStack.size
    }

    /**
     * 退出应用程序
     */
    @Suppress("deprecation")
    fun AppExit(context: Context) {
        try {
            finishAllActivity()
            val activityMgr = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.restartPackage(context.packageName)
            System.exit(0)
        } catch (e: Exception) {
        }
    }

}