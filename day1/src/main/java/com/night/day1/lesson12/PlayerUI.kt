package com.night.day1.lesson12

/**
 * <p>作者：Night  2019/1/5 21:08
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class PlayerUI private constructor() {
    companion object {
        fun get(): PlayerUI = Holder.instance
    }

    private object Holder {
        val instance = PlayerUI()
    }

    fun showPlayer(user: User) {

    }
}