package com.night.coroutines.dispatch.child

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/7 17:59
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")


fun main() = runBlocking {
    log("runBlocking")

    //继承父协程，启动子协程(父协程作用域)
    val request = launch {
        log("request")

        //通过GlobalScope启动的子协程(独立作用域)
        GlobalScope.launch {
            log("GlobalScope in quest")
            println("job1：launch with global scope")
            delay(2000)
            println("job1: not affect by the cancel by request")
        }

        //继承父协程，启动子协程(父协程作用域)
        launch {
            log("child from request")
            println("job2：launch with parent")
            delay(1500)
            println("job2：will not execute")
        }
    }


    GlobalScope.launch {
        log("GlobalScope in runBlocking")
        println("job3：launch")
        delay(1500)
        println("job3：after delay execute")
    }

    delay(1000)
    request.cancel()
    delay(2000)
    println("main：who has survived from request's cancel")
}