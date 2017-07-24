package com.howie.personal.view.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.Toast


/**
 * Created by howie on 2017/7/14.
 */
abstract class BaseAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            initContentView(savedInstanceState)
        }
    }

    // 全屏或者没有ActionBar等
    private fun setBase() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)// 例
    }

    // 初始化UI，setContentView等
    protected abstract fun initContentView(savedInstanceState: Bundle)

    //展示弹窗信息
    protected fun showToast(msg: String) {
        if (msg.isNullOrBlank()) {
            return
        }
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
    }

}