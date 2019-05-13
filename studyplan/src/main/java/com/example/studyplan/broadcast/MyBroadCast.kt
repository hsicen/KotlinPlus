package com.example.studyplan.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.studyplan.util.logd

/**
 * <p>作者：AiCoder  2019/5/12 11:20
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：自定义广播接收器(接收系统发送的广播)
 *
 * 步骤：
 * 1.自定义广播接收器
 * 2.注册广播接收器(静态注册 -> XML文件，动态注册 -> 代码注册)
 * 3.发送广播(Context.sendBroadcast())
 *
 * 注意：intent-filter中的action:name表示要接收的广播
 */
class MyBroadCast : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        logd("接收到系统发送的广播    ${intent?.action}")
    }
}