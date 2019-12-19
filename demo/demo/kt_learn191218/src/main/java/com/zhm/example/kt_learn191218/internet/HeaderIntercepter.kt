package com.zhm.example.kt_learn191218.internet

import okhttp3.Interceptor
import okhttp3.Response
import java.util.HashMap

/**
 * Created by huimin on 2019/12/19.
 */
class HeaderIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        //对参数进行排序
        val bodyToString = NetTool.bodyToString(newBuilder.build().body())
        val mutableMapOf = mutableMapOf<String, String>()
//        val requestParams
//        if (bodyToString.contains("?")) {
//             requestParams = bodyToString.split("\\?")[0].split("&")
//        }


        newBuilder.header("Cookie", "token=1BDE0B5BD5C936E54507635215DD8184")
                .header("userId", "96505655707829248")
//                .header("signValue", SHA1Utils.generate(sb.toString()))
                .header("X-GateWay-appKey", "student")
                .header("X-GateWay-securityToken", "SvyNnwlLWKv1hirppnkF4CSJiWCuIoPV1GTGe52gmtkNmKP/cPCs7wgXilKmkfP1k5HzzFTqgQMEF9TeQSdRT/U5hB9XJT7UWiSe/9jWUJRUWGnXYOIvuLKQQuMM5BO6nyNE8mSM9Hpaet8fHNM6DMYbe2/GMhsxYAjUoUhNXrM=")
        return chain.proceed(newBuilder.build())
    }
}