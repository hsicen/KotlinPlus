package com.night.day1.lesson3;

/**
 * <p>作者：Night  2019/1/4 13:00
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
public class Test {
    public static void main(String[] args) {

        //Java 调用Kotlin
        Lesson3Kt.echo("Hello");

        //Java调用Kotlin的匿名内部类
        Say.INSTANCE.sayMessage("Hello World !");
    }
}
