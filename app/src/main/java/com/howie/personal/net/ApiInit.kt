package com.howie.personal.net

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *
 * Created by howie on 2017/7/14.
 */
object ApiInit {

    fun init(): ApiServer {
        val loggingInterceptor = HttpLoggingInterceptor()
        //包含header、body数据
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(MyGetInterceptor())
                .addNetworkInterceptor(MySetInterceptor())
                .connectTimeout(ApiConfig.TIME_OUT.toLong(), TimeUnit.SECONDS)
                .build()
        val mRetrofit = Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return mRetrofit.create(ApiServer::class.java)
    }

    /**
     * 发出请求的拦截器
     */
    private class MySetInterceptor : Interceptor {
        override fun intercept(p0: Interceptor.Chain?): Response {
            val request = p0!!.request()
            /* 添加每个url的参数
               val httpUrl = request.url()
                     .newBuilder()
                     .addQueryParameter("token", "123")
                     .build()*/
            val build = request.newBuilder()
                    // add common header
                    .addHeader("contentType", "text/json")
                    .addHeader("token", "howie")
                    //.url(httpUrl)
                    .build()
            val response = p0.proceed(build)
            return response
        }

    }

    /**
     * 收到参数的拦击器
     */
    private class MyGetInterceptor : Interceptor {
        override fun intercept(p0: Interceptor.Chain?): Response {
            val request = p0!!.request()
            val response = p0.proceed(request)
            val responseBody = response.peekBody(1024 * 1024)
            Log.e("返回值", responseBody.string())//对错误值进行处理
            val myResponse = response.newBuilder()
            myResponse.code(200)
            return myResponse.build()
        }

    }
}