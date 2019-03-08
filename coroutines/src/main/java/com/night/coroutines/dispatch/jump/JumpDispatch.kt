package com.night.coroutines.dispatch.jump

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * <p>作者：Night  2019/3/7 17:42
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main() {

    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->

            //使用runBlocking 来显示指定一个上下文
            runBlocking(ctx1) {
                log("Start in ctx1")

                //使用withContext 来改变协程的上下文
                withContext(ctx2) {
                    log("Work in ctx2")
                }

                log("Back to ctx1")
            }
        }
    }
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")