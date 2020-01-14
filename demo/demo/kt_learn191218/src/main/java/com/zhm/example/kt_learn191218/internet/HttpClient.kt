package com.zhm.example.kt_learn191218.internet

import android.util.Log
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

/**
 * Created by huimin on 2019/12/18.
 */
class HttpClient {
    companion object {
        //懒加载，使用时才会加载
        val mOkHttpClient by lazy {
            val builder = OkHttpClient.Builder()
//            builder.addInterceptor(HttpLogIntecepter())
            builder.addInterceptor(HeaderIntercepter())
            builder.connectTimeout(100L, TimeUnit.SECONDS)
            builder.readTimeout(100L, TimeUnit.SECONDS)
            builder.writeTimeout(100L, TimeUnit.SECONDS)
            try {
                builder.sslSocketFactory(NetTool.getSSLContext().getSocketFactory())
                builder.hostnameVerifier { hostname, session -> true }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("e", e.message)
            }

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