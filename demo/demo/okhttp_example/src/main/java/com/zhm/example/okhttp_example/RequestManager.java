package com.zhm.example.okhttp_example;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    public static void executeGet(String url) {
        Request.Builder builder = new Request.Builder().url(url)
                .get();
        try {
            mOkHttpClient.newCall(builder.build()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get请求
     * 异步
     */
    public static void enqueueGet(String url) {
        Request.Builder builder = new Request.Builder().url(url).get();
        mOkHttpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

    /**
     * Post请求
     * 同步
     */
    public static void executePost(String url) {
        FormBody.Builder formBody = new FormBody.Builder();
        Request.Builder builder = new Request.Builder().url(url)
                .post(formBody.build());
        try {
            mOkHttpClient.newCall(builder.build()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Post请求
     * 异步
     */
    public static void enqueuePost(String url) {
        FormBody.Builder formBody = new FormBody.Builder();
        Request.Builder builder = new Request.Builder().url(url)
                .post(formBody.build());
        mOkHttpClient.newCall(builder.build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
