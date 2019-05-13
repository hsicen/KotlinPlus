package com.example.studyplan.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.studyplan.R

/**
 * <p>作者：Night  2019/4/28 21:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Activity生命周期测试
 */
class TestActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_testb)
    }

    companion object {

        fun launch(context: Context) {
            val intent = Intent(context, TestActivityB::class.java)
            context.startActivity(intent)
        }
    }
}