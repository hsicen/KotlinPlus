package com.night.jetpack.util

import java.util.*

/**
 * <p>作者：黄思程  2019/4/23 10:53
 * <p>邮箱：codinghuang@163.com
 * <p>功能：
 * <p>描述： 计算帮助类
 */
object Calculate {

    /*** 使用后缀 表达式来计算原表达式的值，得到double类型的结果。 */
    fun calculate(exp: String): String {
        //String转换为List,得到中缀表达式
        val inOrderExp = getStringList(exp)
        val postOrderExp = getPostOrder(inOrderExp)
        val res = calPostOrderExp(postOrderExp)
        //当结果是整数的时候，输出不要加小数点
        return if (res == Math.floor(res)) {
            res.toLong().toString()
        } else res.toString()
    }

    /*** 把数字和符号加入list */
    private fun getStringList(s: String): ArrayList<String> {
        val res = ArrayList<String>()
        var num = StringBuilder()
        for (i in 0 until s.length) {
            if (Character.isDigit(s[i]) || s[i] == '.') {
                num.append(s[i])
            } else {
                if ("" != num.toString()) {
                    //把上一个数字加到list
                    res.add(num.toString())
                }

                //把当前符号加到list
                res.add(s[i] + "")
                num = StringBuilder()
            }
        }
        //最后一个数字
        if ("" != num.toString()) {
            res.add(num.toString())
        }
        return res
    }

    /*** 将中缀表达式转化为后缀表达式 */
    private fun getPostOrder(inOrderExp: ArrayList<String>): ArrayList<String> {
        //储存结果
        val postOrderExp = ArrayList<String>()
        //运算符栈
        val operStack = Stack<String>()

        for (i in inOrderExp.indices) {
            val cur = inOrderExp[i]
            if (isOper(cur)) {
                while (!operStack.isEmpty() && compareOper(operStack.peek(), cur)) {
                    //只要运算符栈不为空，并且栈顶符号优先级大与等于cur
                    postOrderExp.add(operStack.pop())
                }
                operStack.push(cur)
            } else {
                postOrderExp.add(cur)
            }
        }
        while (!operStack.isEmpty()) {
            postOrderExp.add(operStack.pop())
        }
        return postOrderExp
    }

    /*** 比较两个运算符的大小，如果peek优先级大于等于cur，返回true */
    private fun compareOper(peek: String, cur: String): Boolean {
        if ("*" == peek && ("/" == cur || "*" == cur || "+" == cur || "-" == cur)) {
            return true
        } else if ("/" == peek && ("/" == cur || "*" == cur || "+" == cur || "-" == cur)) {
            return true
        } else if ("+" == peek && ("+" == cur || "-" == cur)) {
            return true
        } else if ("-" == peek && ("+" == cur || "-" == cur)) {
            return true
        }
        return false
    }

    //判断一个字符串是否是运算符，+-*/
    private fun isOper(c: String): Boolean {
        return c == "+" ||
                c == "-" ||
                c == "*" ||
                c == "/"
    }

    //计算一个后缀表达式
    private fun calPostOrderExp(postOrderExp: ArrayList<String>): Double {
        val stack = Stack<String>()
        for (i in postOrderExp.indices) {
            val curString = postOrderExp[i]
            if (isOper(curString)) {
                val a = java.lang.Double.parseDouble(stack.pop())
                val b = java.lang.Double.parseDouble(stack.pop())
                var res = 0.0
                when (curString[0]) {
                    '+' -> res = b + a
                    '-' -> res = b - a
                    '/' -> {
                        if (a == 0.0) throw Exception()
                        res = b / a
                    }
                    '*' -> res = b * a
                }
                stack.push(res.toString() + "")
            } else {
                stack.push(curString)
            }
        }
        return java.lang.Double.parseDouble(stack.pop())
    }
}