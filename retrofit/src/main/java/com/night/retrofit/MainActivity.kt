package com.night.retrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iUserBiz = Net.client().create(IUserBiz::class.java)
        val user = iUserBiz.getUser()
        user.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.d("hsc", "failed")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("hsc", "success")
            }
        })
    }
}
