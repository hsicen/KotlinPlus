package com.example.studyplan.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import com.example.studyplan.R
import com.example.studyplan.util.logd
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    private var mBinder: BindService.MyBinder? = null
    private val mCnn by lazy {
        object : ServiceConnection {
            override fun onServiceDisconnected(name: ComponentName?) = logd("断开服务")

            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                logd("服务已连接")
                mBinder = service as BindService.MyBinder

                mBinder?.sayHello("你好，我在Activity中")
                mBinder?.download("http://www.baidu.com")
            }
        }
    }

    //定义一个Intent
    private val startIntent by lazy {
        Intent(this, BindService::class.java)
    }

    private val bindIntent by lazy {
        Intent(this, BindService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)


        //bind
        btnBind.setOnClickListener {
            bindService(bindIntent, mCnn, Context.BIND_AUTO_CREATE)
        }

        //start
        btnStart.setOnClickListener {
            startService(startIntent)
        }
    }

    override fun onDestroy() {
        stopService(startIntent)
        super.onDestroy()
    }
}
