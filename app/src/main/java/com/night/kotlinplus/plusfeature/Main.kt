package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/5 21:44
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
fun main(args: Array<String>) {
    //解构应用于对象的拆解  分别赋值
    val mUser = User(12, "Night young")
    val (age, name) = mUser

    println(age)
    println(name)

    //解构应用于map的遍历   获取对应的值
    val map = mapOf("key" to "key", "value" to "value")
    for ((k, v) in map) {
        println("$k --- $v")
    }
}