package com.howie.personal.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.howie.personal.R
import com.howie.personal.net.ApiAgency
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val http = ApiAgency.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_tv.setOnClickListener(this@MainActivity)

    }


    override fun onClick(view: View?) {
        val id = view?.id
        when (id) {
            R.id.test_tv -> {
                http.GetIp().enqueue(object : Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        Log.d("onFailure", t.toString())
                    }

                    override fun onResponse(call: Call<ResponseBody>?, response: retrofit2.Response<ResponseBody>?) {
                        Log.d("onResponse", response?.body()?.string())
                    }
                })
            }

        }
    }

}
