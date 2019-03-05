package com.night.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * <p>作者：Night  2019/2/16 11:36
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() = runBlocking {

    //同步操作
    var time = measureTimeMillis {
        val one = doSthUsefulOne()
        val two = doSthUsefulTwo()

        println("The answer is ${one + two}")
    }

    println("complete in $time ms")

    //异步操作
    time = measureTimeMillis {
        val one = async { doSthUsefulOne() }
        val two = async { doSthUsefulTwo() }

        println("The answer is ${one.await() + two.await()}")
    }

    println("Sync complete in $time ms")
}

suspend fun doSthUsefulOne(): Int {
    delay(1000)
    return 13
}

suspend fun doSthUsefulTwo(): Int {
    delay(1000)
    return 29
}

