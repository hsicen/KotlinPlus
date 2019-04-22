package com.night.jetpack

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.ArrayMap
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    /*** 操作数栈*/
    private val numStack by lazy { Stack<Int>() }

    /*** 操作符号栈*/
    private val opStack by lazy { Stack<Char>() }

    /*** 自定义操作符优先级*/
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

    /*** 第一个是或否为运算符*/
    private var isOpFirst = true
    /*** 最后一个是或否为运算符*/
    private var isOpFinal = false
    /*** 是否点击了等号*/
    private var isResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        //0~9 和 小数点
        btn_point.setOnClickListener(this)
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

        // + - * ÷ % ^ =
        btn_add.setOnClickListener(this)
        btn_dec.setOnClickListener(this)
        btn_multi.setOnClickListener(this)
        btn_divide.setOnClickListener(this)
        btn_mod.setOnClickListener(this)
        btn_equal.setOnClickListener(this)
        btn_power.setOnClickListener(this)

        // 清除
        btn_clear.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var str = et_input.text.toString()

        when (v?.id) {
            // 0~9
            R.id.btn_0, R.id.btn_1, R.id.btn_2,
            R.id.btn_3, R.id.btn_4, R.id.btn_5,
            R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9 -> {

                if (isResult) return
                et_input.text = str + (v as Button).text
                isOpFirst = false
                isOpFinal = false
            }

            // + - × ÷ % ^ 小数点 .
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
                isOpFinal = true //当前最后一个字符为符号
                isResult = false
            }

            // 小数点
            R.id.btn_point -> {
                //et_input.setText(str + (v as Button).text)
                "暂不支持小数".toast()
            }

            //清除
            R.id.btn_clear -> {
                et_input.text = ""
                et_result.text = ""

                isOpFirst = true
                isOpFinal = false
                isResult = false
            }

            // 求值
            R.id.btn_equal -> {
                if (isOpFirst) return
                val result = getResult(str)
                et_result.text = "$result"
                isResult = true
            }
        }
    }

    /***  根据表达式求值*/
    private fun getResult(str: String): Int {
        if (str.isEmpty()) return 0

        str.forEach { pos ->
            //操作数入栈
            if (pos in '0'..'9') {
                numStack.add(pos.toInt() - 48)
            } else {
                //操作符入栈
                if (opStack.isEmpty()) {
                    opStack.add(pos)
                } else {
                    val top = opStack.peek()
                    val topOp = opMap[top] ?: 0
                    val curOp = opMap[pos] ?: 0

                    if (curOp > topOp) {
                        opStack.add(pos)
                    } else {
                        val right = numStack.pop()
                        val left = numStack.pop()

                        val temp = count(left, right, pos)
                        numStack.add(temp)
                    }
                }
            }
        }

        //判断栈是否为空
        while (opStack.isNotEmpty()) {
            val right = numStack.pop()
            val left = numStack.pop()
            val operation = opStack.pop()

            val tempResult = count(left, right, operation)
            numStack.push(tempResult)
        }

        return numStack.peek()
    }


    /*** 计算值*/
    private fun count(leftNum: Int, rightNum: Int, oper: Char): Int {
        when (oper) {
            '+' -> return leftNum + rightNum
            '-' -> return leftNum - rightNum
            '×' -> return leftNum * rightNum
            '÷' -> {
                if (rightNum == 0) {
                    "除数不能为0".toast()
                    return leftNum
                }

                return leftNum / rightNum
            }
            '%' -> return leftNum % rightNum
            '^' -> return Math.pow(leftNum * 1.0, rightNum * 1.0).toInt()
            else -> return 0
        }
    }

    /*** 提示*/
    private fun String.toast() {
        Toast.makeText(this@MainActivity, this, Toast.LENGTH_SHORT).show()
    }
}
