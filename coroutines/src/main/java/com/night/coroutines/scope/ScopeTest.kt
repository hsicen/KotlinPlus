package com.night.coroutines.scope

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 15:52
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：协程作用域
 */

//main 函数为一个协程作用域
fun main() = runBlocking {

    launch { printMain() }

    //创建一个新的协程作用域，会阻塞当前线程后面代码的执行
    coroutineScope {
        launch {
            delay(100)
            println("Task from new coroutine launch")
        }

        delay(100)

        //在内嵌launch之前输出
        println("Task from coroutine scope")
    }

    //在新协程的launch执行完成后，再执行
    println("coroutine scope is over")
}

private suspend fun printMain() {
    delay(200)
    println("Task from runBlocking")
}