package com.night.coroutines.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：黄思程  2019/3/6 10:56
 * <p>邮箱：codinghuang@163.com
 * <p>功能：
 * <p>描述： 使用通道进行耗时信息的发送
 */
fun main() = runBlocking {

    val channel = Channel<Int>()
    launch {

        for (x in 1..7) {
            channel.send(x * x)
            delay(500)
        }

        //结束信息的发送
        channel.close()
    }

    repeat(6) {

        //等待通道发送信息，然后输出
        println("I received data from channel:  ${channel.receive()}")
    }

    for (y in channel) {

        println("received rest data from channel : $y")
    }

    println("Done")
}