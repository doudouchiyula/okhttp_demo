package com.zhm.example.kt_learn191218.internet

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by huimin on 2019/12/18.
 */
class HttpLogIntecepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        return chain.proceed(chain.request())
    }
}