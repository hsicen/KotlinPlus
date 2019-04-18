package com.night.day1.lesson4

/**
 * <p>作者：Night  2019/1/5 12:40
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

fun main(args: Array<String>) {
    A.a.putNumber(123)
    A.a.putNumber(null)


    function("")

    Tset.sayMsg("Hello")
}

fun function(str: String) {
    val fmt1 = A.format(str)
    //println(fmt1.length)
    //val fmt2: String = A.format(str)
    val fmt3: String? = A.format(str)

    println(fmt3?.length)
}

object Tset {

    @JvmStatic
    fun sayMsg(msg: String) {

        println("say sth is : $msg")
    }
}