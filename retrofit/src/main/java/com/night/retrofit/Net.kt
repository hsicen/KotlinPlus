package com.night.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * <p>作者：Night  2019/2/21 17:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
class Net {

    companion object {

        fun client(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}