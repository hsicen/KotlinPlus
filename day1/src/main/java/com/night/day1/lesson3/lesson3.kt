package com.night.day1.lesson3

import kotlin.reflect.KClass

/**
 * <p>作者：Night  2019/1/4 12:58
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Kotlin 与Java的互调
 */


fun echo(name: String) {
    println("From kotlin $name")
}

object Say {
    fun sayMessage(msg: String) {
        println("The msg is $msg")
    }
}

fun main(args: Array<String>) {
    Say.sayMessage("Hello")

    testClass(JavaMain::class.java)
    testClass(KotlinMain::class)

    println(JavaMain.`in`)
}

//Java class 的引用
fun testClass(clazz: Class<JavaMain>) {
    println(clazz.simpleName)
}

//Kotlin class 的引用
fun testClass(clazz: KClass<KotlinMain>) {
    println(clazz.simpleName)
}
