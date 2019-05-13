package com.example.studyplan.activity

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.studyplan.R
import com.example.studyplan.util.DialogUtil
import com.example.studyplan.util.logd
import kotlinx.android.synthetic.main.layout_activity_testa.*

/**
 * <p>作者：Night  2019/4/28 21:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Activity生命周期测试
 */
class TestActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_testa)
        logd("onCreate()")

        tvToB.setOnClickListener {
            TestActivityB.launch(this)
        }

        btnShowDialog.setOnClickListener {
            DialogUtil.showDialog(this, "测试弹窗生命周期",
                { _, _ -> logd("点击确定") },
                { _, _ -> logd("点击取消") })
        }

        val am = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningTasks = am.getRunningTasks(1)

        runningTasks.forEach {
            logd("${it.id}")
        }
    }

    override fun onStart() {
        super.onStart()
        logd("onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        logd("onRestart()")
    }

    override fun onResume() {
        super.onResume()
        logd("onResume()")
    }

    override fun onPause() {
        super.onPause()
        logd("onPause()")
    }

    override fun onStop() {
        super.onStop()
        logd("onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        logd("onDestroy()")
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, TestActivityA::class.java)
            context.startActivity(intent)
        }
    }
}