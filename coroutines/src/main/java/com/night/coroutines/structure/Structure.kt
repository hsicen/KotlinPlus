package com.night.coroutines.structure

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 15:44
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：结构化的并发
 *
 *
 * 协程和println语句同时执行
 */
fun main() = runBlocking {
    launch {
        println(System.currentTimeMillis())
        delay(1000)
        println("World!")
    }

    println(System.currentTimeMillis())
    println("Hello")
}