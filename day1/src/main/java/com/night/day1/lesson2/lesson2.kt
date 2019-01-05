package com.night.day1.lesson2

/**
 * <p>作者：Night  2019/1/4 12:50
 * <p>邮箱：codinghuang@163.com
 * <p>作用：基础语法
 * <p>描述：KotlinPlus
 */

var age: Int = 18  //var 可变的变量
var name: String = "Huang Si Cheng"   //val 不可变的变量

var name2: String? = null

fun main(args: Array<String>) {
    // name = name2!!
    name2 = name

    println("Hello world!")
    printLen(name)
}


fun printLen(str: String): String {

    println("$str 的长度是: ${str.length}")
    return str
}
