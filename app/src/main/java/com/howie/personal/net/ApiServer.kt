package com.howie.personal.net

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.Call

/**
 * Created by howie on 2017/7/14.
 */
interface ApiServer {
    @GET("getIpInfo.php")
    fun GetIp(): Call<ResponseBody>
}