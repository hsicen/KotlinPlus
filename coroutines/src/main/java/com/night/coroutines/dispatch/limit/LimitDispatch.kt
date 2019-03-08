package com.night.coroutines.dispatch.limit

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/7 17:28
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
fun main() = runBlocking<Unit>(Dispatchers.IO) {

    launch(Dispatchers.Unconfined) {
        println("Unconfined：Start in thread ${Thread.currentThread().name}")
        delay(500)
        println("Unconfined：After delay in thread ${Thread.currentThread().name}")
    }

    launch {
        println("Blocking：Start in thread ${Thread.currentThread().name}")
        delay(100)
        println("Blocking：After delay in thread ${Thread.currentThread().name}")
    }
}