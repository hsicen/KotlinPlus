package com.night.day1.lesson12

/**
 * <p>作者：Night  2019/1/5 21:06
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
data class User(
    var id: Int, var name: String,
    var playerType: PlayerViewType = PlayerViewType.BLUE
)
