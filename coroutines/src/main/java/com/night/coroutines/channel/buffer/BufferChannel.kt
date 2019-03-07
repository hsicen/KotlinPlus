package com.night.coroutines.channel.buffer

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 16:21
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() = runBlocking {

    val channel = Channel<Int>(4)

    val sender = launch {
        repeat(10) {

            println("prepare to send  $it")
            channel.send(it)
        }

        channel.cancel()
    }

    delay(2000)
    sender.cancel()
}