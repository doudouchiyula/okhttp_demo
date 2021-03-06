package com.zhm.example.kt_learn191218

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zhm.example.kt_learn191218.R.id.recycle_ciew
import com.zhm.example.kt_learn191218.internet.HttpClient
import com.zhm.example.kt_learn191218.internet.NetTool
import okhttp3.Call
import okhttp3.Response
import java.io.IOException
import javax.security.auth.callback.Callback
import kotlin.reflect.KClass

/**
 * Created by huimin on 2019/12/18.
 */
class ListActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycle_ciew)
    }

    private val messageAdapter: MessageAdapter by lazy {
        MessageAdapter(this, null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_list)
        initRecycleConfig()
        requestFormServer()
    }

    private fun initRecycleConfig() {

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = linearLayoutManager


    }

    private fun requestFormServer() {
        HttpClient.postCall(
                "http://dev.gateway.yimilan.com/notification-center/pull/msg/getMessage/v4",
                "96505655707829248", object : okhttp3.Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("okhttp---", "e=" + e.message)

            }

            override fun onResponse(call: Call, response: Response) {
                val fromJson = GsonBuilder().create().fromJson<ResultUtil<MessageBean>>(response.body()?.string(), ResultUtil::class.java)
                Log.i("zhm----", "fromJson="+fromJson)

                runOnUiThread {
                    //展示列表

//                    fromJsonm
//                    messageAdapter?.resetData()
                }
            }
        })
    }
}


