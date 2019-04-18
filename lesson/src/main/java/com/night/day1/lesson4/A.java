package com.night.day1.lesson4;

/**
 * <p>作者：Night  2019/1/5 12:42
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
public class A implements AInterface {

    public static final A a = new A();

    public static String format(String str) {

        return str.isEmpty() ? null : str;
    }

    public static void main(String[] args) {

        Tset.sayMsg("Hello");
        Tset.INSTANCE.sayMsg(" World");
    }

    @Override
    public void putNumber(int num) {
        System.out.println("int");
    }

    @Override
    public void putNumber(Integer num) {
        System.out.println("Integer");
    }

}
