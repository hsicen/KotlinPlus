package com.night.day1.lesson12

/**
 * <p>作者：Night  2019/1/5 21:11
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
sealed class PlayerViewType {
    object GREEN : PlayerViewType()
    object BLUE : PlayerViewType()
    class Vip(val title: String, val msg: String) : PlayerViewType()
}

fun getPlayerView(type: PlayerViewType) = when (type) {

    PlayerViewType.GREEN -> GreenPlayerView()
    PlayerViewType.BLUE -> BluePlayerView()
    is PlayerViewType.Vip -> VipPlayer(type.title, type.msg)
}

interface PlayerView {
    fun showView()
    fun getPlayButton()
}

class BluePlayerView : PlayerView {
    override fun showView() {
        println("显示蓝色播放器")
    }

    override fun getPlayButton() {
        println("显示蓝色Button")
    }
}

class GreenPlayerView : PlayerView {
    override fun showView() {

    }

    override fun getPlayButton() {
        println("显示绿色Button")
    }
}

class MediaPlayerView(playerView: PlayerView) : PlayerView by playerView
