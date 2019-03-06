package com.night.coroutines.channel.produce

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 14:00
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：通道是单个值在多个协程之间进行传递
 */
@ExperimentalCoroutinesApi
fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        send(x * x)
        println("生产者：生产${x * x}")
    }
}

@ExperimentalCoroutinesApi
fun main() = runBlocking {
    val squares = produceSquares()
    squares.consumeEach {
        println("消费者：消费$it")
    }

    println("Done")
}