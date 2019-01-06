package com.night.coroutines

import kotlinx.coroutines.channels.Channel

/**
 * <p>作者：Night  2019/1/6 20:51
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

val fibonacci = sequence {
    yield(1)
    var cur = 1
    var next = 1

    while (true) {
        yield(next)
        val tmp = cur + next
        cur = next
        next = tmp
    }
}

fun main(args: Array<String>) {
    fibonacci.take(30).iterator().forEach {
        print("$it   ")
    }
}


suspend fun get(channel: Channel<Int>) {
    while (true) {
        println(channel.receive())
    }
}

suspend fun put(channel: Channel<Int>) {
    var i = 0
    while (true) {
        channel.send(i++)
    }
}

