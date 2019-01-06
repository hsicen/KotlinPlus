package com.night.kotlinplus.plusfeature

import java.io.File

/**
 * <p>作者：Night  2019/1/6 16:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * Kotlin中的特殊符号 ``
 * == 和 equals 方法
 * ==(值相等) 和 ===(引用相等)
 */

fun `1234`() {
    println("test1")
}

fun `222`() {
    println("test2")
}


public typealias A = File

fun main(args: Array<String>) {
    val mFile = A("./*.iml")
}
