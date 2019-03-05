package com.night.coroutines.final_realse

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 16:47
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：在finally中释放资源
 */

fun main() = runBlocking {

    val job = launch {

        try {
            repeat(1000) {

                println("I'm sleeping $it ......")
                delay(500)
            }
        } finally {
            println("I'm running finally")
        }
    }

    delay(1300)
    println("main：I'm tired of waiting ...")
    job.cancelAndJoin()
    println("main：Now i can quit")
}