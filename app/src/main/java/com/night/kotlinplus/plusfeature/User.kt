package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/5 21:42
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class User(var age: Int, var name: String) {

    operator fun component1() = age
    operator fun component2() = name
}