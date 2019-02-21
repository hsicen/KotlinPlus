package com.night.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import java.lang.Thread.sleep

/**
 * <p>作者：Night  2019/2/16 10:43
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() = runBlocking {
    //testDefault()

    //testLazy()

    //testJoin()

    //testRepeat()

    //testChannel()

    val squares = produce {

        for (x in 1..5) send(x * x)
    }

    squares.consumeEach { println(it) }
    println("Done!")
}

private suspend fun CoroutineScope.testChannel() {
    val channel = Channel<String>()
    launch {

        repeat(50) {
            channel.send("msg from launch send by channel $it")
            sleep(1000)
        }
    }

    repeat(50) {
        println("Got msg ${channel.receive()}")
    }
}

private fun CoroutineScope.testRepeat() {
    val job = launch {
        repeat(100) {
            println(it)
            sleep(50)
        }
    }
}

private suspend fun testJoin() {
    val job = GlobalScope.launch {
        delay(1000)
        println("World !")

        delay(1000)
    }

    println("Hello,")
    job.join()
    println("Good !")
}

private fun testLazy() {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        println("World !")
    }

    print("Hello ")
    job.start()
    sleep(2000)
}

private fun testDefault() {
    GlobalScope.launch {
        delay(1000)

        println("World !")
    }

    print("Hello ")
    sleep(1500)
}