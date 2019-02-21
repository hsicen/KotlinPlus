package com.night.pageview.page

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * <p>作者：Night  2019/2/20 14:43
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class PageView(context: Context, attrs: AttributeSet?, def: Int) : View(context, attrs, def) {

    private val mRect by lazy { RectF() }

    //初始化画笔
    private val mPaintPink by lazy {
        Paint().apply {
            color = Color.rgb(255, 155, 192)
            style = Paint.Style.STROKE
            strokeWidth = 3f
            isAntiAlias = true
        }
    }

    private val mPaintRed by lazy {
        Paint().apply {
            color = Color.rgb(255, 99, 71)
            style = Paint.Style.STROKE
            strokeWidth = 3f
            isAntiAlias = true
        }
    }

    private val mPaintBlack by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = 3f
            isAntiAlias = true
        }
    }

    private val mPaintWhite by lazy {
        Paint().apply {
            color = Color.BLACK
            style = Paint.Style.STROKE
            strokeWidth = 3f
            isAntiAlias = true
        }
    }


    //初始化动画
    private var mProgressNose = 0
    private var mProgressEyes = 0
    private var mProgressFace = 0
    private var mProgressMouth = 0
    private var mProgressLegs = 0
    private var mProgressFeet = 0

    private val mAnimNose by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressNose = it.animatedValue as Int
                invalidate()
            }

            duration = 1000
        }
    }

    private val mAnimEyes by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressEyes = it.animatedValue as Int
                invalidate()
            }

            duration = 800
        }
    }

    private val mAnimFace by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressFace = it.animatedValue as Int
                invalidate()
            }

            duration = 800
        }
    }

    private val mAnimMouth by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressMouth = it.animatedValue as Int
                invalidate()
            }

            duration = 500
        }
    }

    private val mAnimLegs by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressLegs = it.animatedValue as Int
                invalidate()
            }

            duration = 400
        }
    }

    private val mAnimFeet by lazy {
        ValueAnimator.ofInt(0, 100).apply {
            addUpdateListener {
                mProgressFeet = it.animatedValue as Int
                invalidate()
            }

            duration = 400
        }
    }

    private val mAnimHead by lazy {
        val headPath = PagePath()
        mPath.moveTo(mPointHead.x, mPointHead.y)
        headPath.moveTo(mPointHead.x, mPointHead.y)
        headPath.curveTo((-100).toPx(), 80.toPx(), 130.toPx(), 330.toPx(), 170.toPx(), 170.toPx())
        headPath.quadTo(210.toPx(), 170.toPx(), 240.toPx(), 155.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), headPath.getPoints().toTypedArray())
            .apply {

                addUpdateListener {
                    mPointHead = it.animatedValue as PagePoint
                    invalidate()
                }

                duration = 3000
            }
    }

    private val mAnimEar1 by lazy {
        val pathEar1 = PagePath()
        mPathEar1.moveTo(mPointEar1.x, mPointEar1.y)
        pathEar1.moveTo(mPointEar1.x, mPointEar1.y)
        pathEar1.curveTo(120.toPx(), 50.toPx(), 160.toPx(), 50.toPx(), 150.toPx(), 102.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathEar1.getPoints().toTypedArray()).apply {

            addUpdateListener {
                mPointEar1 = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 600
        }
    }

    private val mAnimEar2 by lazy {
        val pathEar2 = PagePath()
        mPathEar2.moveTo(mPointEar2.x, mPointEar2.y)
        pathEar2.moveTo(mPointEar2.x, mPointEar2.y)
        pathEar2.curveTo(80.toPx(), 53.toPx(), 120.toPx(), 52.toPx(), 120.toPx(), 105.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathEar2.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointEar2 = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 600
        }
    }

    private val mAnimBody by lazy {
        val pathBody = PagePath()
        mPathBody.moveTo(mPointBody.x, mPointBody.y)
        pathBody.moveTo(mPointBody.x, mPointBody.y)
        pathBody.quadTo(50.toPx(), 270.toPx(), 50.toPx(), 320.toPx())
        pathBody.quadTo(100.toPx(), 320.toPx(), 180.toPx(), 320.toPx())
        pathBody.quadTo(180.toPx(), 270.toPx(), 150.toPx(), 210.toPx())

        ValueAnimator.ofObject(PagePathEvaluator(), pathBody.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointBody = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 2000
        }

    }

    private val mAnimArmRight by lazy {
        val pathArmRight = PagePath()
        mPathArmRight.moveTo(mPointArmRight.x, mPointArmRight.y)
        pathArmRight.moveTo(mPointArmRight.x, mPointArmRight.y)
        pathArmRight.quadTo(170.toPx(), 230.toPx(), 210.toPx(), 245.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathArmRight.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointArmRight = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 500
        }
    }

    private val mAnimHandRight by lazy {
        val pathHandRight = PagePath()
        mPathHandRight.moveTo(mPointHandRight.x, mPointHandRight.y)
        pathHandRight.moveTo(mPointHandRight.x, mPointHandRight.y)
        pathHandRight.quadTo(190.toPx(), 242.toPx(), 207.toPx(), 255.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathHandRight.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointHandRight = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 500
        }
    }

    private val mAnimArmLeft by lazy {
        val pathArmLeft = PagePath()
        mPathArmLeft.moveTo(mPointArmLeft.x, mPointArmLeft.y)
        pathArmLeft.moveTo(mPointArmLeft.x, mPointArmLeft.y)
        pathArmLeft.quadTo(70.toPx(), 230.toPx(), 20.toPx(), 245.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathArmLeft.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointArmLeft = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 500
        }
    }

    private val mAnimHandLeft by lazy {
        val pathHandLeft = PagePath()
        mPathHandLeft.moveTo(mPointHandLeft.x, mPointHandLeft.y)
        pathHandLeft.moveTo(mPointHandLeft.x, mPointHandLeft.y)
        pathHandLeft.quadTo(190.toPx(), 242.toPx(), 207.toPx(), 255.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathHandLeft.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointHandLeft = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 500
        }
    }

    private val mAnimTail by lazy {
        val pathTail = PagePath()
        mPathTail.moveTo(mPointTail.x, mPointTail.y)
        pathTail.moveTo(mPointTail.x, mPointTail.y)
        pathTail.curveTo(30.toPx(), 330.toPx(), 30.toPx(), 280.toPx(), 40.toPx(), 300.toPx())
        pathTail.curveTo(40.toPx(), 320.toPx(), 20.toPx(), 300.toPx(), 0.toPx(), 310.toPx())
        ValueAnimator.ofObject(PagePathEvaluator(), pathTail.getPoints().toTypedArray()).apply {

            addUpdateListener {

                mPointTail = it.animatedValue as PagePoint
                invalidate()
            }

            duration = 1200
        }
    }

    private val mAnimatorSet by lazy {

        AnimatorSet().apply {

            playSequentially(
                mAnimNose, mAnimHead, mAnimEar1, mAnimEar2,
                mAnimEyes, mAnimMouth, mAnimFace, mAnimBody, mAnimArmRight,
                mAnimHandRight, mAnimArmLeft, mAnimHandLeft, mAnimLegs,
                mAnimFeet, mAnimTail
            )
        }
    }


    //初始化路径
    private var mPointHead = PagePoint(220.toPx(), 102.toPx())
    private var mPointEar1 = PagePoint(130.toPx(), 105.toPx())
    private var mPointEar2 = PagePoint(100.toPx(), 110.toPx())
    private var mPointBody = PagePoint(80.toPx(), 210.toPx())
    private var mPointArmRight = PagePoint(160.toPx(), 233.toPx())
    private var mPointHandRight = PagePoint(210.toPx(), 235.toPx())
    private var mPointArmLeft = PagePoint(70.toPx(), 233.toPx())
    private var mPointHandLeft = PagePoint(20.toPx(), 235.toPx())
    private var mPointTail = PagePoint(51.toPx(), 300.toPx())

    private val mPath = Path()
    private val mPathEar1 = Path()
    private val mPathEar2 = Path()
    private val mPathBody = Path()
    private val mPathArmRight = Path()
    private val mPathHandRight = Path()
    private val mPathArmLeft = Path()
    private val mPathHandLeft = Path()
    private val mPathTail = Path()

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //draw nose
        mRect.set(200.toPx(), 101.toPx(), 250.toPx(), 160.toPx())
        canvas.rotate(-15f, 225.toPx(), 150.toPx())
        mPaintPink.style = if (mProgressNose < 100) Paint.Style.STROKE else Paint.Style.FILL
        mPaintRed.style = if (mProgressNose < 100) Paint.Style.STROKE else Paint.Style.FILL
        canvas.drawArc(mRect, 0f, mProgressNose * 3.6f, false, mPaintPink)
        canvas.rotate(15f, 225.toPx(), 130.toPx())

        mRect.set(213.toPx(), 125.toPx(), 223.toPx(), 135.toPx())
        canvas.drawArc(mRect, 0f, mProgressNose * 3.6f, false, mPaintRed)
        mRect.set(230.toPx(), 122.toPx(), 240.toPx(), 132.toPx())
        canvas.drawArc(mRect, 0f, mProgressNose * 3.6f, false, mPaintRed)

        //draw eyes
        mPaintPink.style = Paint.Style.STROKE
        mPaintRed.style = Paint.Style.STROKE

        mRect.set(110.toPx(), 115.toPx(), 140.toPx(), 145.toPx())
        canvas.drawArc(mRect, 0f, mProgressEyes * 3.6f, false, mPaintPink)
        mRect.set(145.toPx(), 105.toPx(), 175.toPx(), 135.toPx())
        canvas.drawArc(mRect, 0f, mProgressEyes * 3.6f, false, mPaintPink)

        mPaintBlack.style = if (mProgressEyes < 100) Paint.Style.STROKE else Paint.Style.FILL

        mRect.set(123.toPx(), 123.toPx(), 133.toPx(), 133.toPx())
        canvas.drawArc(mRect, 0f, mProgressEyes * 3.6f, false, mPaintBlack)
        mRect.set(158.toPx(), 113.toPx(), 168.toPx(), 123.toPx())
        canvas.drawArc(mRect, 0f, mProgressEyes * 3.6f, false, mPaintBlack)

        //draw face
        mPaintPink.style = if (mProgressFace < 100) Paint.Style.STROKE else Paint.Style.FILL
        mRect.set(70.toPx(), 160.toPx(), 95.toPx(), 190.toPx())
        canvas.drawArc(mRect, 0f, mProgressFace * 3.6f, false, mPaintBlack)

        //draw mouth
        mRect.set(110.toPx(), 175.toPx(), 155.toPx(), 200.toPx())
        canvas.drawArc(mRect, 165f, -mProgressMouth * 1.8f, false, mPaintBlack)

        //draw leg
        mPaintPink.style = Paint.Style.STROKE
        canvas.drawRect(95.toPx(), 320.toPx(), 98.toPx(), (320 + 30 * mProgressLegs / 100).toPx(), mPaintPink)
        canvas.drawRect(130.toPx(), 320.toPx(), 133.toPx(), (320 + 30 * mProgressLegs / 100).toPx(), mPaintPink)

        //draw feet
        mRect.set(90.toPx(), 350.toPx(), (90 + 20 * mProgressFeet / 100).toPx(), 360.toPx())
        canvas.drawRoundRect(mRect, 5.toPx(), 5.toPx(), mPaintBlack)
        mRect.set(125.toPx(), 350.toPx(), (125 + 20 * mProgressFeet / 100).toPx(), 360.toPx())
        canvas.drawRoundRect(mRect, 5.toPx(), 5.toPx(), mPaintBlack)

        //draw head
        mPath.lineTo(mPointHead.x, mPointHead.y)
        canvas.drawPath(mPath, mPaintPink)

        mPathEar1.lineTo(mPointEar1.x, mPointEar1.y)
        canvas.drawPath(mPathEar1, mPaintPink)
        mPathEar2.lineTo(mPointEar2.x, mPointEar2.y)
        canvas.drawPath(mPathEar2, mPaintPink)
        mPathBody.lineTo(mPointBody.x, mPointBody.y)
        canvas.drawPath(mPathBody, mPaintPink)
        mPathArmRight.lineTo(mPointArmRight.x, mPointArmRight.y)
        canvas.drawPath(mPathArmRight, mPaintPink)
        mPathHandRight.lineTo(mPointHandRight.x, mPointHandRight.y)
        canvas.drawPath(mPathHandRight, mPaintPink)
        mPathArmLeft.lineTo(mPointArmLeft.x, mPointArmLeft.y)
        canvas.drawPath(mPathArmLeft, mPaintPink)
        mPathHandLeft.lineTo(mPointHandLeft.x, mPointHandLeft.y)
        canvas.drawPath(mPathHandLeft, mPaintPink)

        mPathTail.lineTo(mPointTail.x, mPointTail.y)
        canvas.drawPath(mPathTail, mPaintPink)
    }


    fun startAnimation() {
        reSet()
        mAnimatorSet.start()
    }

    private fun reSet() {

        mPath.reset()
        mPathEar1.reset()
        mPathEar2.reset()
        mPathBody.reset()
        mPathArmRight.reset()
        mPathHandRight.reset()
        mPathArmLeft.reset()
        mPathHandLeft.reset()
        mPathTail.reset()
    }

    private fun Int.toPx(): Float {
        val scale = context.resources.displayMetrics.density
        return this * scale + 0.5f
    }

    private fun Int.toPxInt(): Int {
        val scale = context.resources.displayMetrics.density
        return (this * scale + 0.5f).toInt()
    }
}