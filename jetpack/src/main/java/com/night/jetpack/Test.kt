package com.night.jetpack

/**
 * <p>作者：Night  2019/4/22 9:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class Test {


}

fun main(args: Array<String>) {

    println("-1! = ${factorial(-1)}")
}

private fun factorial(n: Int): Int {
    if (n <= 1) return 1

    return n * factorial(n - 1)
}