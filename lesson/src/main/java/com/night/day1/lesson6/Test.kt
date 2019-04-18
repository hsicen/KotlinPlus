package com.night.day1.lesson6

import java.io.File
import java.nio.charset.Charset

/**
 * <p>作者：Night  2019/1/5 13:33
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * 扩展函数
 */

fun File.readText(charSet: Charset = Charsets.UTF_8):
        String = readBytes().toString(charSet)

open class Animal

class Dog : Animal()

fun Animal.name() = " Animal"

fun Dog.name() = "Dog"

fun Animal.printName(animal: Animal) {
    println(animal.name())
}


fun main(args: Array<String>) {

    //扩展函数的静态解析     Dog被强转为了Animal
    Dog().printName(Dog())
}


