package com.night.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * <p>作者：Night  2019/3/5 15:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class MyTest {

    @Test
    fun testMySuspendingFunction() = runBlocking {

        //test  block method
        GlobalScope.launch {
            delay(1000)

            println("World")
        }

        print("Hello")
        delay(2000)
    }
}