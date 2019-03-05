package com.night.coroutines.over

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * <p>作者：Night  2019/3/5 17:14
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：规定协程运行时间
 */

fun main() = runBlocking {

    val result = withTimeoutOrNull(1300) {
        repeat(2) {
            println("I'm sleeping $it ......")
            delay(500)
        }

        //如果携程执行完，结果为Done,否则为null
        "Done"
    }

    println("The result is：$result")
}