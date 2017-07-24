package com.howie.personal

import android.app.Application

/**
 * Created by howie on 2017/7/14.
 */
class App : Application() {
    private var app: App = null!!
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    fun getInstance(): App {
        return app
    }
}