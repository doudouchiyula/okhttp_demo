package com.zhm.example.kt_learn191218.internet

import okhttp3.*
import java.io.IOException

/**
 * Created by huimin on 2019/12/18.
 */
class HttpClient {
    //懒加载，使用时才会加载
    private val mOkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.build()
    }


    public fun postCall(url: String) {
        val request = Request.Builder().url(url).post(FormBody.Builder().build()).build()
        mOkHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

    }
}