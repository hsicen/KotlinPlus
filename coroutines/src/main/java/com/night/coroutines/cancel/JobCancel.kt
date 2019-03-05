package com.night.coroutines.cancel

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 16:21
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() = runBlocking {

    val job = launch {
        repeat(1000) {

            println("I'm sleeping $it...")
            delay(500)
        }
    }


    delay(1300)
    println("main：I'm tired of waiting")
    job.cancel() //取消协程的执行
    job.join()//等待协程执行完毕

    println("main：Now i can quit")
}