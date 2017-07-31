package com.howie.personal.utils

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.howie.personal.App

/**
 * Created by howie on 2017/7/14.
 */
class Utils {

    companion object {
        fun getInstance() = Holder.instance
    }

    private object Holder {
        val instance = Utils()
    }

    private fun getNetWorkInfo(): NetworkInfo {
        val context = App().getInstance().applicationContext!!
        val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connManager.activeNetworkInfo
        return info
    }

    /**
     * 判断是否有网络连接
     */
    fun isNetConn(): Boolean {
        val info = getNetWorkInfo()
        return info.state == NetworkInfo.State.CONNECTED
    }

    /**
     * 判断是否是WIFI
     */
    fun isWifiConn(): Boolean {
        val info = getNetWorkInfo()
        return (info != null && info.isConnected && info.type == ConnectivityManager.TYPE_WIFI)
    }

    /**
     * 判断是不是手机网络
     */
    fun isMobileConn(): Boolean {
        val info = getNetWorkInfo()
        return (info != null && info.isConnected && info.type == ConnectivityManager.TYPE_MOBILE)
    }

    /**
     * 获取屏幕的宽度
     */
    fun getScreenWidth(): Int {
        val re = Resources.getSystem().displayMetrics
        return re.widthPixels
    }

    /**
     * 获取屏幕的高度
     */
    fun getScreenHeight(): Int {
        val re = Resources.getSystem().displayMetrics
        return re.heightPixels
    }


}