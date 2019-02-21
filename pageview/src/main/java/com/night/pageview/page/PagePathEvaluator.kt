package com.night.pageview.page

import android.animation.TypeEvaluator

/**
 * <p>作者：Night  2019/2/20 13:57
 * <p>邮箱：codinghuang@163.com
 * <p>作用：动画差值器
 * <p>描述：KotlinPlus
 */
class PagePathEvaluator : TypeEvaluator<PagePoint> {

    override fun evaluate(
        fraction: Float,
        startValue: PagePoint, endValue: PagePoint
    ): PagePoint {
        val x: Float
        val y: Float

        //确定起点
        var startX: Float = if (startValue.operation == PagePath.QUAD) startValue.x1 else startValue.x
        startX = if (startValue.operation == PagePath.CURVE) startValue.x2 else startX
        var startY: Float = if (startValue.operation == PagePath.QUAD) startValue.y1 else startValue.y
        startY = if (startValue.operation == PagePath.CURVE) startValue.y2 else startY

        when (endValue.operation) {
            PagePath.LINE -> {
                //一阶贝塞尔函数公式    当前值 = 起始点 + t * (结束点-起始点)
                x = startX + fraction * (endValue.x - startX)
                y = startY + fraction * (endValue.y - startY)
            }

            PagePath.CURVE -> {
                val oneMinusT = 1 - fraction
                //三阶贝塞尔函数公式
                x = oneMinusT * oneMinusT * oneMinusT * startX +
                        3 * oneMinusT * oneMinusT * fraction * endValue.x +
                        3 * oneMinusT * fraction * fraction * endValue.x1 +
                        fraction * fraction * fraction * endValue.x2

                y = oneMinusT * oneMinusT * oneMinusT * startY +
                        3 * oneMinusT * oneMinusT * fraction * endValue.y +
                        3 * oneMinusT * fraction * fraction * endValue.y1 +
                        fraction * fraction * fraction * endValue.y2
            }

            PagePath.MOVE -> {
                //重新设置起点
                x = endValue.x
                y = endValue.y
            }

            PagePath.QUAD -> {
                val oneMinusT = 1 - fraction
                //二阶贝塞尔函数公式
                x = oneMinusT * oneMinusT * startX +
                        2 * oneMinusT * fraction * endValue.x +
                        fraction * fraction * endValue.x1

                y = oneMinusT * oneMinusT * startY +
                        2 * oneMinusT * fraction * endValue.y +
                        fraction * fraction * endValue.y1
            }

            else -> {
                x = endValue.x
                y = endValue.y
            }
        }

        return PagePoint(x, y)
    }

}