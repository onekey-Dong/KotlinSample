package com.onekey.kotlinsample.base

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by onekey on 2019/6/20.
 */
abstract class BaseActivity : AppCompatActivity() {

    abstract fun getContentViewID(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewID())
        initView()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    open fun umengTitle(): String {
        return ""
    }

    open fun initView() {}

    fun startAct(clazz: Class<in Any>): Unit {
        var intent = Intent(this, clazz)
        startActivity(intent)
    }

    fun isActDestroy(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return isFinishing || supportFragmentManager == null || supportFragmentManager.isDestroyed
        }
        return isFinishing || isDestroyed
    }
}