package com.night.coroutines.delay

import kotlinx.coroutines.*

/**
 * <p>作者：Night  2019/3/5 17:06
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：挂起一个被取消的协程
 */

fun main() = runBlocking {

    val job = launch {

        try {
            repeat(1000) {

                println("I'm sleeping $it .....")
                delay(500)
            }
        } finally {
            withContext(NonCancellable) {
                println("I'm running finally")
                delay(5000)
                println("And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }

    delay(1300)
    println("main：I'm tired of waiting ...")
    job.cancelAndJoin()
    println("main：Now i can quit")
}