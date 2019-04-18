package com.night.day1.lesson6

import java.io.File

/**
 * <p>作者：Night  2019/1/5 13:43
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main(args: Array<String>) {
    val mFile = File("KotlinPlus.iml")
    println(mFile.readText())
}