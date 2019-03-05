package com.night.coroutines.light

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 16:14
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：测试启动大量协程
 */

fun main() = runBlocking {

    repeat(100_000) {
        launch {
            delay(1000)
            println(it)
        }
    }
}