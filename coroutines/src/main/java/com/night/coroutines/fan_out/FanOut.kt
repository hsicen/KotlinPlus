package com.night.coroutines.fan_out

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 15:57
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */


fun CoroutineScope.produceNumbers(source: Int) = produce {
    var start = source

    while (true) {

        send(start++)
        delay(100)
    }
}


/**
 * 使用通道发送字符串
 */
suspend fun sendString(channel: SendChannel<String>, str: String, delayTime: Long) {

    while (true) {

        channel.send(str)
        delay(delayTime)
    }
}


fun main() = runBlocking {

    val channel = Channel<String>()
    launch { sendString(channel, "Java", 200) }
    launch { sendString(channel, "Python", 100) }
    launch { sendString(channel, "Kotlin", 50) }

    //接收通道的前10个数据
    repeat(10) { println(channel.receive()) }
    coroutineContext.cancelChildren()
}