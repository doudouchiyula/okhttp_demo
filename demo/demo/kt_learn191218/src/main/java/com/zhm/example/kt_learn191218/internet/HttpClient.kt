package com.zhm.example.kt_learn191218.internet

import okhttp3.*
import java.io.IOException

/**
 * Created by huimin on 2019/12/18.
 */
class HttpClient {
    companion object {
        //懒加载，使用时才会加载
        val mOkHttpClient by lazy {
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(HttpLogIntecepter())
            builder.build()
        }

        fun postCall(url: String,userId : String,callback: Callback) {
            val builder = FormBody.Builder()
            builder.add("userId",userId)

            val requestBuilder = Request.Builder()
            requestBuilder.url(url)

            val request = requestBuilder.post(builder.build()).build()
            mOkHttpClient.newCall(request).enqueue(callback)

        }
    }


}