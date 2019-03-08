package com.night.coroutines.dispatch

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/7 16:52
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：指定Dispatcher
 */

fun main() = runBlocking<Unit> {

    //从启动它的CoroutineScope中继承了上下文
    launch {
        println("Main Blocking：I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined：I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default：I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("IO：I'm working in thread ${Thread.currentThread().name}")
    }

    /*launch(Dispatchers.Main) {
        println("Main：I'm working in thread ${Thread.currentThread().name}")
    }*/

    val singleThreadContext = newSingleThreadContext("My Own Thread")
    launch(singleThreadContext) {
        println("New Thread：I'm working in thread ${Thread.currentThread().name}")
        //使用完后进行关闭
        singleThreadContext.close()
    }
}
