package com.night.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/5 14:45
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Kotlin协程
 */
fun main() {

    //后台启动一个新的协程
    GlobalScope.launch {
        //延时1s
        delay(1000)

        println("delay print：Hello word")
    }

    /*thread {
        //延时1s
        //delay(1000)
        Thread.sleep(1000)

        println("delay print：Hello word")
    }*/


    println("Hello world!")
    //阻塞主线程2s,保证JVM存活
    //Thread.sleep(2000)

    //下面这个表达式会阻塞主线程
    runBlocking {
        delay(2000)
    }

    //下面这句话会在上面那个表达式之后执行
    println("after launch")
}