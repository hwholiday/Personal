package com.howie.personal

import com.howie.personal.bean.User
import com.howie.personal.net.ApiAgency
import okhttp3.ResponseBody
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Callback

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun Data() {
        var user = User("Name", "Pass")
        user = user.copy(Pass = "howie")
        print(user.toString())
    }

    @Test
    fun Net() {
        val http = ApiAgency.getInstance()
        http.GetIp().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                print("onFailure")
                print(t)
            }

            override fun onResponse(call: Call<ResponseBody>?, response: retrofit2.Response<ResponseBody>?) {
                print("onResponse")
                print(response)
            }
        })
    }
}
