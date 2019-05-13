package com.example.studyplan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.studyplan.activity.TestActivityA
import com.example.studyplan.broadcast.BroadCastActivity
import com.example.studyplan.service.ServiceActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {

        btnActivity.setOnClickListener {
            TestActivityA.launch(this)
        }

        btnService.setOnClickListener {
            startActivity(Intent(this, ServiceActivity::class.java))
        }

        btnBroadcast.setOnClickListener {
            startActivity(Intent(this, BroadCastActivity::class.java))
        }
    }
}
