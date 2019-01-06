package com.night.coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/1/1 22:51
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Kotlin协程
 *
 * runBlocking: T
 * launch : Job
 * async/await ：Deferred
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun displayDashbord(textView: TextView) = runBlocking {
        launch (){  }
    }
}
