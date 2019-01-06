package com.night.coroutines

import kotlinx.coroutines.channels.Channel

/**
 * <p>作者：Night  2019/1/6 21:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */

//全局缓存池
var map = mutableMapOf<String, Channel<Any>>()

inline fun <reified T> T.post() {
    if (!map.containsKey(T::class.java.name)) {
        map[T::class.java.name] = Channel()
    }
}