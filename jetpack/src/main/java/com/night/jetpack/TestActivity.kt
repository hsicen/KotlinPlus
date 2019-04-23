package com.night.jetpack

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.ArrayMap
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * <p>作者：Night  2019/4/23 11:06
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class TestActivity : AppCompatActivity(), View.OnClickListener {
    /*** 操作数栈*/
    private val numStack by lazy { Stack<Int>() }
    /*** 操作符栈*/
    private val opStack by lazy { Stack<Char>() }
    /*** 定义操作符优先级*/
    private val opMap by lazy {
        ArrayMap<Char, Int>().apply {
            put('+', 1)
            put('-', 1)
            put('×', 2)
            put('÷', 2)
            put('%', 2)
            put('^', 2)
        }
    }

    /*** 第一个是否为操作符*/
    private var isOpFirst = true
    /*** 最后一个是否为操作符*/
    private var isOpFinal = false
    /*** 是否求出结果*/
    private var isResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    /*** 初始化点击事件*/
    private fun initListener() {
        //0 ~ 9 and .
        btn_0.setOnClickListener(this)
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_point.setOnClickListener(this)

        //+ - × ÷ % ^ =
        btn_add.setOnClickListener(this)
        btn_dec.setOnClickListener(this)
        btn_multi.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        btn_mod.setOnClickListener(this)
        btn_power.setOnClickListener(this)
        btn_equal.setOnClickListener(this)

        // clear
        btn_clear.setOnClickListener(this)
    }

    /*** 点击事件的处理*/
    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var str = et_input.text.toString()

        when (v?.id) {
            //0 ~ 9
            R.id.btn_0, R.id.btn_1, R.id.btn_2,
            R.id.btn_3, R.id.btn_4, R.id.btn_5,
            R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9 -> {
                if (isResult) return
                et_input.text = str + (v as Button).text
                isOpFirst = false
                isOpFinal = false
            }

            //+ - × ÷ % ^
            R.id.btn_add, R.id.btn_dec, R.id.btn_multi,
            R.id.btn_divide, R.id.btn_mod, R.id.btn_power
            -> {
                if (isOpFirst) return
                else if (isOpFinal && str != "") {
                    str = et_input.text.toString()
                    et_input.text = str.substring(0, str.length - 1) + (v as Button).text
                    return
                }

                et_input.text = str + (v as Button).text
                isOpFinal = true
                isResult = false
            }

            // 小数
            R.id.btn_point -> {
                //et_input.text = str + (v as Button).text
                toast("暂不支持小数")
            }

            // 求值
            R.id.btn_equal -> {
                if (isOpFirst) return
                val result = getResult(str)
                et_result.text = "$result"
                isResult = true
            }

            // 清除数据
            R.id.btn_clear -> {
                et_input.text = ""
                et_result.text = ""

                isOpFirst = true
                isOpFinal = false
                isResult = false
            }
        }
    }

    /*** 求出表达式的值*/
    private fun getResult(str: String): Int {
        if (str.isEmpty()) return 0

        var numStr = ""
        str.forEach { pos ->

            if (pos in '0'..'9' || '.' == pos) {
                numStr += pos
            } else {
                //操作数入栈
                if (numStr.isNotEmpty()) {
                    numStack.add(numStr.toInt())
                }

                //操作符入栈
                if (opStack.isEmpty()) {
                    opStack.add(pos)
                } else {
                    val top = opStack.peek()

                    val curOp = opMap[pos] ?: 0
                    val topOp = opMap[top] ?: 0

                    if (curOp > topOp) {
                        opStack.add(pos)
                    } else {
                        val right = numStack.pop()
                        val left = numStack.pop()

                        val temp = count(left, right, pos)
                        numStack.add(temp)
                    }
                }

                //清空临时保存的数
                numStr = ""
            }
        }

        //最后一位操作数入栈
        if (numStr.isNotEmpty()) {
            numStack.add(numStr.toInt())
        }

        //判断操作符栈是否为空
        while (opStack.isNotEmpty()) {
            val right = numStack.pop()
            val left = numStack.pop()
            val op = opStack.pop()

            val temp = count(left, right, op)
            numStack.add(temp)
        }

        return numStack.peek()
    }

    /*** 根据操作符计算值*/
    private fun count(left: Int, right: Int, pos: Char): Int {
        when (pos) {
            '+' -> return (left + right)
            '-' -> return (left - right)
            '×' -> return (left * right)
            '÷' -> {
                if (right == 0) {
                    toast("除数不能为0")
                    return left
                }

                return (left / right)
            }

            '%' -> return (left % right)
            '^' -> return Math.pow(left * 1.0, right * 1.0).toInt()
            else -> return 0
        }
    }

    private fun Context.toast(str: String) {
        str.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}