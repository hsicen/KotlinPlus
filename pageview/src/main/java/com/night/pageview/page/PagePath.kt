package com.night.pageview.page

/**
 * <p>作者：Night  2019/2/20 13:46
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class PagePath {
    val mPoints by lazy { ArrayList<PagePoint>() }

    fun moveTo(x: Float, y: Float) =
        mPoints.add(PagePoint.moveTo(x, y, MOVE))

    fun lineTo(x: Float, y: Float) =
        mPoints.add(PagePoint.lineTo(x, y, LINE))

    fun curveTo(x: Float, y: Float, x1: Float, y1: Float, x2: Float, y2: Float) =
        mPoints.add(PagePoint.curveTo(x, y, x1, y1, x2, y2, CURVE))

    fun quadTo(x: Float, y: Float, x1: Float, y1: Float) =
        mPoints.add(PagePoint.quadTo(x, y, x1, y1, QUAD))

    fun getPoints(): Collection<PagePoint> {
        return mPoints
    }

    companion object {

        const val MOVE = 0
        const val LINE = 1
        const val QUAD = 2
        const val CURVE = 3
    }
}