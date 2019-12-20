package com.zhm.example.kt_learn191218.internet

import okhttp3.Interceptor
import okhttp3.Response
import java.net.URLEncoder
import java.util.*

/**
 * Created by huimin on 2019/12/19.
 */
class HeaderIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        //对参数进行排序
        val bodyToString = NetTool.bodyToString(newBuilder.build().body())
        val mutableMapOf = mutableMapOf<String, String>()

        var requestParams: List<String>
        if (bodyToString.contains("?")) {
            requestParams = bodyToString.split("\\?")[0].split("&")
        } else {
            requestParams = bodyToString.split("&")
        }

        requestParams.forEach {
            val key = it.split("=")
            if (key.size >= 2) {
                mutableMapOf.put(key[0], URLEncoder.encode(key[1], "UTF-8"))
            } else {
                mutableMapOf.put(key[0], "")
            }
        }

        val associateBy = mutableMapOf.entries.sortedBy { it.value.length }.associateBy({ it.key }, { it.value })

        val sb = StringBuilder()
        for (entry in associateBy) {
            if (sb.toString().isNotEmpty()) {
                sb.append("&").append(entry.key).append("=").append(entry.value)
            } else {
                sb.append(entry.key).append("=").append(entry.value)
            }
        }

        newBuilder.header("Cookie", "token=9A18E88E82A352C2A16391486715FF53")
                .header("userId", "96505655707829248")
                .header("signValue", SHA1Utils.generate(sb.toString()))
                .header("X-GateWay-appKey", "student")
                .header("X-GateWay-securityToken", "SvyNnwlLWKv1hirppnkF4CSJiWCuIoPV1GTGe52gmtkNmKP/cPCs7wgXilKmkfP1k5HzzFTqgQMEF9TeQSdRT/U5hB9XJT7UWiSe/9jWUJRUWGnXYOIvuLKQQuMM5BO6nyNE8mSM9Hpaet8fHNM6DMYbe2/GMhsxYAjUoUhNXrM=")
        return chain.proceed(newBuilder.build())
    }
}