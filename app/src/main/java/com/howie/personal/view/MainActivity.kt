package com.howie.personal.view

import android.os.Bundle
import com.howie.personal.R
import com.howie.personal.view.base.BaseAppActivity

class MainActivity : BaseAppActivity() {

    override fun initContentView(savedInstanceState: Bundle) {
        setContentView(R.layout.activity_main)
    }

}
