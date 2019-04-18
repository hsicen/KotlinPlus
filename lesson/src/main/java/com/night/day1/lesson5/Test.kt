package com.night.day1.lesson5

/**
 * <p>作者：Night  2019/1/5 13:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus  Kotlin函数语法
 *
 * 默认值函数
 * 直接返回值函数
 * 嵌套函数：内部函数可以访问外部函数的局部变量，内部函数不能被外部函数访问
 * 在某些条件下触发递归的函数，不希望被外部函数访问到的函数
 */


//外部函数
fun function() {
    val str = "hello !"  //外部函数局部变量

    fun say(count: Int = 10) { //内部函数
        println(str)
        if (count > 0) say(count - 1)
    }

    say()
}

fun print(name: String = "Huang Si Cheng"): String? {
    println(name)

    return name
}

fun main(args: Array<String>) {
    function()
}