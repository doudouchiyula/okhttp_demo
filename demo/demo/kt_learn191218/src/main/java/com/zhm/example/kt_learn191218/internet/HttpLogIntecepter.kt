package com.zhm.example.kt_learn191218.internet

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by huimin on 2019/12/18.
 */
class HttpLogIntecepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        Log.e("okhttp-",response.toString())
        return response
    }
}