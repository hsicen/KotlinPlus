package com.night.coroutines.channel.equal

import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * <p>作者：Night  2019/3/6 16:35
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

data class Ball(var hits: Int)

suspend fun player(name: String, table: Channel<Ball>) {

    for (ball in table) {

        ball.hits++
        println("$name is hit $ball")
        table.send(ball)
        delay(800)
    }
}

fun main() = runBlocking {

    //定义一个乒乓球桌子
    val table = Channel<Ball>()

    //定义两名玩家
    launch { player("张帅", table) }
    launch { player("吴磊", table) }

    //发球
    table.send(Ball(0))

    //一局游戏5s,然后取消游戏
    delay(5000)
    coroutineContext.cancelChildren()
    println("游戏结束")
}
