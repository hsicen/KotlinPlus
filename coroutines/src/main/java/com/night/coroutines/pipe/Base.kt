package com.night.coroutines.pipe

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 14:48
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
fun main() = runBlocking {

    val nums = produceNums()
    val square = square(nums)

    for (index in 1..5) {
        println("Received：${square.receive()}")
    }

    println("Done")
    coroutineContext.cancelChildren()
}

fun CoroutineScope.produceNums() = produce {
    var x = 1

    while (true) send(x++)
}

fun CoroutineScope.square(nums: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {

    for (x in nums) {
        send(x * x)
    }
}