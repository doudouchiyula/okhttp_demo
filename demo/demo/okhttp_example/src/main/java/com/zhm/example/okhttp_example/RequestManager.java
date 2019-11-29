package com.zhm.example.okhttp_example;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;

/**
 * Created by huimin on 2019/11/29.
 */
public class RequestManager {
    public final static String GET = "GET";
    public final static String POST = "POST";
    public final static String USER_AGENT = "YML Android "
            + (android.os.Build.VERSION.RELEASE != null ? android.os.Build.VERSION.RELEASE : "debug");

    private final static int CONNECT_TIMEOUT = 60;
    private final static int READ_TIMEOUT = 100;
    private final static int WRITE_TIMEOUT = 100;
    public static OkHttpClient mOkHttpClient;

    //第一种方式
    static {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);
        try {
            builder.sslSocketFactory(SSLUtils.getSSLContext().getSocketFactory());
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.retryOnConnectionFailure(true);
        mOkHttpClient = builder.build();
    }

    //第二种方式
//    static {
//        OkHttpClient okHttpClient = new OkHttpClient();
//    }

    /**
     * Get请求
     * 同步
     */
    public static void executeGet() {

    }

    /**
     * Get请求
     * 异步
     */
    public static void enqueueGet() {

    }

    /**
     * Post请求
     * 同步
     */
    public static void executePost() {

    }

    /**
     * Post请求
     * 异步
     */
    public static void enqueuePost() {

    }
}
