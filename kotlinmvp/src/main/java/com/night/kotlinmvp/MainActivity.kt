package com.night.kotlinmvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.night.kotlinmvp.presenter.IPresenter
import com.night.kotlinmvp.view.IView

/**
 * <p>作者：Night  2019/1/1 22:58
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：Kotlin MVP框架
 *
 * MVC：View  Controller  Model
 * MVP:  View  Presenter   Model
 */
class MainActivity : AppCompatActivity(),
    IView by MVPView(), IPresenter by EmptyPresenter() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }
}


class EmptyPresenter : IPresenter {
    override fun doLogin() {
        //执行各种逻辑
    }
}

class MVPView : IView {
    override fun getLayoutId(): Int = R.layout.activity_main
}
