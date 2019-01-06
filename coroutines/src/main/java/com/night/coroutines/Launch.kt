package com.night.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/1/6 19:38
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main(args: Array<String>) = runBlocking {
    val job = launch {
        repeat(1000) {
            println("挂起中...$it")
            delay(500)
        }
    }

    val job2 = async {
        delay(500)
        return@async "Hello"
    }

    println("job2:  ${job2.await()}")

    delay(1300)
    println("main::  主线程等待中...")
    job.cancel()
    job.join()
    println("main::  即将完成退出...")
}