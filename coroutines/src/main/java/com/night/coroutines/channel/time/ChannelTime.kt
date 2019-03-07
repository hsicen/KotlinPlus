package com.night.coroutines.channel.time

import kotlinx.coroutines.channels.TickerMode
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * <p>作者：Night  2019/3/7 9:26
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：通道计时器
 */
fun main() = runBlocking {

    //创建计时器通道， 每次发送延时100ms, 初始化延时0毫秒
    val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0, mode = TickerMode.FIXED_DELAY)
    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Initial element is available：$nextElement")

    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() }
    println("Next element is not ready in 50ms：$nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100ms：$nextElement")

    //模拟大量耗时延迟
    println("Mock consume for 150ms")
    delay(150)

    //下一个元素立即可用
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is immediately with some consume：$nextElement")

    //在receive 调用之前，延迟的时间都被考虑在内(TickerMode.FIXED_DELAY)
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready for 60ms：$nextElement")

    //表明不在需要更多的元素，停止发送
    tickerChannel.cancel()
}

