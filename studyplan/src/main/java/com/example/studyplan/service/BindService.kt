package com.example.studyplan.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import com.example.studyplan.util.logd

/**
 * <p>作者：AiCoder  2019/5/1 20:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：BindService
 */
class BindService : Service() {
    private val mBinder by lazy {
        MyBinder()
    }

    override fun onCreate() {
        super.onCreate()

        logd("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        logd("onStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()

        logd("onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {

        logd("onBind")
        return mBinder
    }

    override fun onUnbind(intent: Intent?): Boolean {

        logd("onUnbind")
        return super.onUnbind(intent)
    }

    /*** 用于Service和Activity进行通信*/
    class MyBinder : Binder() {

        fun sayHello(str: String) = logd("information from activity is:  $str")

        fun download(str: String) = logd("开始下载链接： $str")
    }
}