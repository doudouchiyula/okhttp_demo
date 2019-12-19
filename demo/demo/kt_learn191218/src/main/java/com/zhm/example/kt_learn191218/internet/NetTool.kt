package com.zhm.example.kt_learn191218.internet

import okhttp3.RequestBody
import okio.Buffer
import java.io.IOException

/**
 * Created by huimin on 2019/12/19.
 */
class NetTool {
    companion object {
        fun bodyToString(request: RequestBody?): String {
            try {
                val buffer = Buffer()
                if (request != null) {
                    request.writeTo(buffer)
                    return buffer.readUtf8()
                } else {
                    return ""
                }
            } catch (var2: IOException) {
                return "did not work"
            }

        }
    }

}