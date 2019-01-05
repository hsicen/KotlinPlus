package com.night.day1.lesson6;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

import java.io.File;

/**
 * <p>作者：Night  2019/1/5 13:48
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
public class JavaMain {

    public static void main(String[] args) {

        File mFile = new File("KotlinPlus.iml");
        String mContent = FilesKt.readText(mFile, Charsets.UTF_8);
        System.out.println(mContent);
    }
}
