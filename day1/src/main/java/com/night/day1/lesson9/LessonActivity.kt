package com.night.day1.lesson9

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.night.day1.R

/**
 * <p>作者：Night  2019/1/5 17:54
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：次构造函数必须显示的继承主构造函数或者父构造函数
 */
//主构造函数  父类无参构造方法
class LessonActivity(var name: String) : AppCompatActivity(), View.OnClickListener {

    constructor(age: Int, name: String) : this(name)

    //构造函数中执行相关操作
    init {
        println("init： $name")
    }


    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
    }
}
