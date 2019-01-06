package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/6 10:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * 集合操作符
 */

fun main(args: Array<String>) {
    val list = arrayListOf('A', 'B', 'C', 'D', 'E')
    val aIndex = list.map { it - 'a' }   //将一个类型转换为另一个类型
        .filter { it > 0 } //过滤掉不符合条件的元素
        .find { it > 1 } //找到符合条件的元素

    val a = arrayOf("4", "0", "7", "i", "f", "w", "0", "9", "s", "3", "d")
    val index = arrayOf(5, 3, 19, 4, 8, 23, 1, 9, 2, 1, 7, 12, 9, 22, 16)

    index.filter { it < a.size }
        .map { a[it] }
        .reduce { acc, s -> "$acc$s" }
        .also { println("密码是：$it") }
}

inline fun <T, E> Iterable<T>.convert(action: (T) -> E): MutableList<E> {
    val list: MutableList<E> = mutableListOf()
    for (item in this) list.add(action(item))
    return list
}

fun myOperator() {
    val list = listOf(1, 2, 3, 4, 5)
    list.convert { it + 1 }
        .forEach { println(it) }
}