package com.howie.personal.bean

import java.util.ArrayList
import java.util.Arrays
import java.util.Collections

import okhttp3.Call

/**
 * Created by howie on 2017/7/19.
 */

class Adb {
    private val mCallList = Collections.synchronizedList(ArrayList<Call>())

    private fun asd(vararg ex: Call) {
        mCallList.removeAll(Arrays.asList(*ex))
    }
}
