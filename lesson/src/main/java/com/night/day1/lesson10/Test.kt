package com.night.day1.lesson10

/**
 * <p>作者：Night  2019/1/5 17:57
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 *
 * 访问修饰符：public  protected  private  internal
 * 伴生对象：companion object
 */

class StringUtils {
    companion object {

        fun isEmpty(str: String): Boolean {
            return "" == str
        }
    }
}

class Single private constructor() {
    companion object {

        fun get(): Single = Holder.instance
    }

    private object Holder {
        val instance = Single()
    }
}


fun main(args: Array<String>) {

    val mInstance = Single.get()
}