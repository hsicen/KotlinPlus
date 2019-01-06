package com.night.kotlinplus.plusfeature

/**
 * <p>作者：Night  2019/1/6 12:13
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 * 作用域函数：run   with(T)  let     apply   also
 * 对数据做变换，可以应用于所有对象
 */

data class Person(var name: String, var age: Int, var sex: String)

fun main(args: Array<String>) {

    val mPerson = Person("Night", 12, "男")

    //let 和 run 都会返回闭包的执行结果 （最后一行作为闭包的结果返回）
    //区别在于let有闭包参数   run没有闭包参数
    val mLetResult = mPerson.let {
        "let:: ${it.javaClass}"
    }

    val mRunResult = mPerson.run {
        "run:: ${this.javaClass}"
        "Hello Kotlin  $this"
    }

    println(mLetResult)
    println(mRunResult)


    //also 和 apply 都不会返回闭包执行的结果
    //区别在于also有闭包参数(it)    apply没有闭包参数(this)
    mPerson.also {
        it.name = "Young"
        it.age = 18
        it.sex = "男"
    }

    mPerson.apply {
        name = "Young"
        age = 12
        sex = "女"
    }


    //takeIf 的闭包返回一个判断结果，为false时，takeIf会返回null
    mPerson.takeIf { it.name.isNotEmpty() }?.also { println("姓名为：${it.name}") } ?: println("姓名为Null")
    //takeUnless 的闭包返回一个判断结果，为true时会返回null
    mPerson.takeUnless { it.name.isNotEmpty() }?.also { println("姓名为Null") } ?: println("姓名为：${mPerson.name}")


    //repeat  重复执行当前闭包
    repeat(5) {
        print(mPerson.name)
        println(it)
    }


    //with 不是以扩展函数的形式存在的 是以定顶级函数的形式存在的
    //相当于apply
    with(mPerson) {
        this.name = "Night Young"
        this.age = 18
        this.sex = "男女"
    }


}