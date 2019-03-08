package com.night.coroutines.organize

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * <p>作者：Night  2019/3/7 15:31
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：组合挂起函数(suspend)
 */

suspend fun doSthUsefulOne(): Int {
    delay(1000)
    return 25
}

suspend fun doSthUsefulTwo(): Int {
    delay(1500)
    return 29
}

fun main() = runBlocking {

    //阻塞主线程的方式计算
    var time = measureTimeMillis {
        val one = doSthUsefulOne()
        val two = doSthUsefulTwo()

        println("The answer is ${one + two}")
    }
    println("The consume time is $time")

    //异步的方式计算
    time = measureTimeMillis {
        /*val one = async(start = CoroutineStart.LAZY) { doSthUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSthUsefulTwo() }
        one.start()
        two.start()*/

        println("The answer is ${concurrentSum()}")
    }
    println("The async time is $time")
}

fun doSthUsefulOneAsync() = GlobalScope.async {
    doSthUsefulOne()
}

fun doSthUsefulTwoAsync() = GlobalScope.async {
    doSthUsefulTwo()
}

suspend fun concurrentSum(): Int = coroutineScope {

    val one = async { doSthUsefulOne() }
    val two = async { doSthUsefulTwo() }

    one.await() + two.await()
}

