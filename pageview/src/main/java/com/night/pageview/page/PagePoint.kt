package com.night.pageview.page

/**
 * <p>作者：Night  2019/2/20 11:06
 * <p>邮箱：codinghuang@163.com
 * <p>作用：贝塞尔曲线坐标信息
 * <p>描述：KotlinPlus
 */
class PagePoint(
    val x: Float = 0f, val y: Float = 0f,
    val x1: Float = 0f, val y1: Float = 0f,
    val x2: Float = 0f, val y2: Float = 0f,
    val operation: Int = 1
) {

    companion object {
        /** 移动到某点*/
        fun moveTo(x: Float, y: Float, operation: Int) =
            PagePoint(x = x, y = y, operation = operation)

        /** 一阶贝塞尔曲线点坐标*/
        fun lineTo(x: Float, y: Float, operation: Int) =
            PagePoint(x = x, y = y, operation = operation)

        /** 二阶贝塞尔曲线点坐标*/
        fun quadTo(x: Float, y: Float, x1: Float, y1: Float, operation: Int) =
            PagePoint(x = x, y = y, x1 = x1, y1 = y1, operation = operation)

        /** 三阶贝塞尔曲线点坐标*/
        fun curveTo(x: Float, y: Float, x1: Float, y1: Float, x2: Float, y2: Float, operation: Int) =
            PagePoint(x, y, x1, y1, x2, y2, operation)
    }
}