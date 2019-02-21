package com.night.retrofit

import retrofit2.Call
import retrofit2.http.GET

/**
 * <p>作者：Night  2019/2/21 17:11
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
interface IUserBiz {

    @GET("users")
    fun getUser(): Call<List<User>>
}