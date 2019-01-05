package com.night.day1.lesson7

/**
 * <p>作者：Night  2019/1/5 14:03
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * Lambda函数闭包
 */

fun main(args: Array<String>) {

    val mThread = Thread {

    }
    mThread.start()

    lambdaA(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
}

//闭包函数
val echo = { name: String ->
    println(name)
}

val lambdaA = { a: Int, b: Int, c: Int, d: Int, e: Int, f: Int, g: Int, h: Int,
                i: Int, j: Int, k: Int, l: Int, m: Int, n: Int, o: Int, p: Int,
                q: Int, r: Int, x: Int, s: Int, t: Int, u: Int, v: Int, w: Int ->

    println("Night young")
}




