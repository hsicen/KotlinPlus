package com.example.studyplan.util

import android.util.Log

/**
 * <p>作者：Night  2019/4/29 15:00
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：全局扩展
 */

fun logd(msg: String, tag: String = "hsc") {
    Log.d(tag, msg)
}

fun loge(msg: String, tag: String = "hsc") {
    Log.e(tag, msg)
}