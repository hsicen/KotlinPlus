package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/6 16:00
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * 自定义中缀表达式
 */

sealed class CompareResult {

    object LESS : CompareResult() {
        override fun toString(): String {
            return "小于"
        }
    }

    object MORE : CompareResult() {
        override fun toString(): String {
            return "大于"
        }
    }

    object EQUAL : CompareResult() {
        override fun toString(): String {
            return "等于"
        }
    }
}

infix fun Int.vs(num: Int): CompareResult =
    when {
        this - num < 0 -> CompareResult.LESS
        this - num > 0 -> CompareResult.MORE
        else -> CompareResult.EQUAL
    }

fun main(args: Array<String>) {
    println(5 vs 6)
}