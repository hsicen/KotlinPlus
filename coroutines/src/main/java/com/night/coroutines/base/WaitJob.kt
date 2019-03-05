package com.night.coroutines.base

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 15:22
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：等待一个协程
 */

fun main() = runBlocking {

    val job = GlobalScope.launch {
        delay(5000)

        println("World!")
    }

    print("Hello ")

    //启动job，会阻塞主线程
    job.join()
}