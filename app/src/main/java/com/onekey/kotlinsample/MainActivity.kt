package com.onekey.kotlinsample

import android.os.Bundle
import android.view.View

import com.onekey.kotlinsample.base.BaseActivity

class MainActivity : BaseActivity() {

    fun onBtnClick(view: View) {
        when (view.id) {
            R.id.btnToKotlin -> BaseActivity.launch(this, KotlinActivity::class.java)
            R.id.btnToOne -> {
                val bundle = Bundle()
                bundle.putInt("index", 1)
                BaseActivity.launch(this, KotlinActivity::class.java, bundle)
            }
            R.id.btnToTwo -> {
                val bundle = Bundle()
                bundle.putInt("index", 2)
                BaseActivity.launch(this, KotlinActivity::class.java, bundle)
            }
        }
    }

    override fun getContentViewID(): Int {
        return R.layout.activity_main
    }
}
