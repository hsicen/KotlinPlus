package com.night.coroutines.dispatch.name

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/8 10:20
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：重新命名协程，方便调试
 */

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking(CoroutineName("Computing")) {
    log(" Start from main")

    val v1 = async(CoroutineName("V1")) {
        delay(500)
        log("Computing v1")

        21
    }

    val v2 = async(CoroutineName("V2")) {
        delay(600)
        log("Computing v2")

        23
    }

    println("The result of v1 plus v2 is ${v1.await() + v2.await()}")
}

