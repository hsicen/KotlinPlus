package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/6 10:37
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * Kotlin中的循环
 * 循环时可以对map或者集合进行解构，分别获取对应的值
 *
 * for((index, value) in list.withIndex)
 */

fun main(args: Array<String>) {

    //第一种循环  [1,10] 闭区间
    for (pos in 1..10) {
        println(pos)
    }

    println("----------------")
    //第二种循环 [1,10)  左闭右开
    for (pos in 1 until 10) {
        println(pos)
    }

    println("----------------")
    //第三种  10-1
    for (pos in 10 downTo 1)
        println(pos)

    println("----------------")
    //1,3,5,7,9
    for (pos in 100 downTo 10 step 2)
        println(pos)

    println("----------------")
    //0-9
    repeat(10) {
        println(it)
    }


    val list = listOf("A", "B")
    for ((index, value) in list.withIndex()) {
        println("$index --is-- $value")
    }
}