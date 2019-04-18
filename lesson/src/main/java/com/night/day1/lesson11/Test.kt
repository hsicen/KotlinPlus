package com.night.day1.lesson11

/**
 * <p>作者：Night  2019/1/5 18:08
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus  动态代理by
 *
 * 静态代理调用    Java：反射调用
 */

interface Animal {
    fun bark()
}

class Dog : Animal {
    override fun bark() {
        println("Dog: bark")
    }
}

class Zoo(animal: Animal) : Animal by animal

fun main(args: Array<String>) {
    Zoo(Dog()).bark()
}