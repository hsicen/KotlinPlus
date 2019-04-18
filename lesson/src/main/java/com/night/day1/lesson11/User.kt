package com.night.day1.lesson11

/**
 * <p>作者：Night  2019/1/5 18:20
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * 数据类：final类型
 * 枚举类：密闭类，可以有子类，必须写在同一个文件中
 */
data class User(val name: String, val age: Int)


//枚举类
enum class Commad {
    A, B, C, D
}

fun exec(commad: Commad) = when (commad) {
    Commad.A -> {
    }
    Commad.B -> {
    }
    Commad.C -> {
    }
    Commad.D -> {
    }
}

//密闭类
sealed class SuperCommand {
    object A : SuperCommand()
    object B : SuperCommand()
    object C : SuperCommand()
    object D : SuperCommand()
}

fun exec(superCommand: SuperCommand) = when (superCommand) {
    SuperCommand.A -> {
    }
    SuperCommand.B -> {
    }
    SuperCommand.C -> {
    }
    SuperCommand.D -> {
    }
}