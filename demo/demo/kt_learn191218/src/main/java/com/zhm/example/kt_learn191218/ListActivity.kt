package com.zhm.example.kt_learn191218

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zhm.example.kt_learn191218.internet.HttpClient
import com.zhm.example.kt_learn191218.internet.NetTool
import okhttp3.Call
import okhttp3.Response
import java.io.IOException
import javax.security.auth.callback.Callback

/**
 * Created by huimin on 2019/12/18.
 */
class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_list)
        initRecycleConfig()
        requestFormServer()
    }

    private fun initRecycleConfig() {

    }

    private fun requestFormServer() {
        HttpClient.postCall(
                "http://dev.gateway.yimilan.com/notification-center/pull/msg/getMessage/v4",
                "96505655707829248", object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("okhttp---", "e=" + e.message)

            }

            override fun onResponse(call: Call, response: Response) {
                runOnUiThread {

                }
            }
        })
    }
}