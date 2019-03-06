package com.night.coroutines.fan_all

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 15:42
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：多个协程接收相同的管道
 */

fun CoroutineScope.produceNums() = produce {
    var x = 1

    while (true) {
        send(x++)
        delay(100)
    }
}


fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {

    for (msg in channel) {
        println("processor $id received $msg")
    }
}


fun main() = runBlocking {

    val nums = produceNums()

    repeat(5) {

        launchProcessor(it, nums)
    }

    delay(2000)
    nums.cancel()
}



