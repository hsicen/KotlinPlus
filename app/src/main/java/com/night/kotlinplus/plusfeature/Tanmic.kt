package com.night.kotlinplus.plusfeature

import com.google.gson.Gson

/**
 * <p>作者：Night  2019/1/6 18:21
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

inline fun <reified T> Gson.fromJson(json: String):
        T = fromJson(json, T::class.java)















