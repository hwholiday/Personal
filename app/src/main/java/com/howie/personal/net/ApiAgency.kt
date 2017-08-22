package com.howie.personal.net

import okhttp3.ResponseBody
import retrofit2.Call
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by howie on 2017/7/14.
 */
class ApiAgency {
    var api = ApiInit.init()

    private var mCallList = Collections.synchronizedList(ArrayList<Call<ResponseBody>>())

    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = ApiAgency()
    }

    fun GetIp(): Call<ResponseBody> {
        val call: Call<ResponseBody> = api.GetIp()
        mCallList.add(call)
        return call
    }


    fun cancelAll(vararg call: Call<ResponseBody>) {
        if (call.size > 0) {
            mCallList.removeAll(Arrays.asList(*call))
        }
        if (mCallList != null) {
            mCallList
                    .filter { it != null && !it.isCanceled }
                    .forEach { it.cancel() }
            mCallList.clear()
            mCallList = null
        }
    }

}