package com.night.day1.lesson8

/**
 * <p>作者：Night  2019/1/5 16:56
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus    高阶函数
 */

//第一个参数为Boolean   第二个参数为 ->参数为空，返回值为Unit的函数
inline fun onlyIf(isDebug: Boolean, block: () -> Unit) {
    if (isDebug) {
        block()
    }
}

val mRunnable = Runnable { println("Runnable:: run") }
val mFunction: () -> Unit = mRunnable::run

fun main(args: Array<String>) {
    onlyIf(true, mFunction)
}