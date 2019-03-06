package com.night.coroutines.pipe.odd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 15:10
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() = runBlocking {

    var mNums = numFrom(6)

    for (i in 1..10) {
        val prime = mNums.receive()
        println(prime)
        mNums = filter(mNums, prime)
    }

    coroutineContext.cancelChildren()
}


fun CoroutineScope.numFrom(source: Int) = produce {

    var start = source
    while (true) send(start++)
}

fun CoroutineScope.filter(nums: ReceiveChannel<Int>, filter: Int) = produce {

    for (x in nums) {

        if (x % filter != 0) send(x)
    }
}
