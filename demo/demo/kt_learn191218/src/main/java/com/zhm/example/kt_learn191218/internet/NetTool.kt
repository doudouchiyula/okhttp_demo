package com.zhm.example.kt_learn191218.internet

import okhttp3.RequestBody
import okio.Buffer
import java.io.IOException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

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

        @Throws(Exception::class)
        fun getSSLContext(): SSLContext {
            val trustAllCerts = arrayOfNulls<TrustManager>(1)
            val tm = miTM()
            trustAllCerts[0] = tm
            val sc = SSLContext.getInstance("SSL")
            sc.init(null, trustAllCerts, null)
            return sc
        }

        internal class miTM : TrustManager, X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }


            fun isServerTrusted(certs: Array<X509Certificate>): Boolean {
                return true
            }

            fun isClientTrusted(certs: Array<X509Certificate>): Boolean {
                return true
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) {
            }
        }


    }

}