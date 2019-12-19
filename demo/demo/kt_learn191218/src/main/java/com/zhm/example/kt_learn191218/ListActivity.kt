package com.zhm.example.kt_learn191218

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zhm.example.kt_learn191218.internet.HttpClient

/**
 * Created by huimin on 2019/12/18.
 */
class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_list)
        HttpClient.postCall("http://dev.gateway.yimilan.com/notification-center/pull/msg/getMessage/v4",
                "96505655707829248")
    }
}