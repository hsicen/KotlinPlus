package com.night.coroutines.cancel2

import kotlinx.coroutines.*

/**
 * <p>作者：Night  2019/3/5 16:34
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：协程不能取消的情况
 *
 * 协程的取消是协作的，在执行协程任务时，要判断协程是否active
 */

fun main() = runBlocking {

    val startTIme = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {

        var nextPrintTime = startTIme
        var i = 0
        while (i < 15 && isActive) {

            if (System.currentTimeMillis() >= nextPrintTime) {

                println("I'm sleeping ${i++} ....")
                nextPrintTime += 500
            }
        }
    }

    delay(1300)
    println("main：I'm tired of waiting")
    job.cancel()
    job.join()

    println("main：Now i can quit")
}