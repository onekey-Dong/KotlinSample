package com.onekey.kotlinsample.base

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.onekey.kotlinsample.BuildConfig

/**
 * Created by onekey on 2019/6/20.
 */
abstract class BaseActivity : AppCompatActivity() {

    protected val TAG = this.javaClass.simpleName

    companion object {

        fun launch(context: Context, clazz: Class<*>) {
            var intent = Intent(context, clazz)
            context.startActivity(intent)
        }

        fun launch(context: Context, clazz: Class<*>, data: Bundle) {
            var intent = Intent(context, clazz)
            intent.putExtras(data)
            context.startActivity(intent)
        }

        fun launch(activity: AppCompatActivity, clazz: Class<*>, requestCode: Int) {
            var intent = Intent(activity, clazz)
            activity.startActivityForResult(intent, requestCode)
        }

        fun launch(activity: AppCompatActivity, clazz: Class<*>, requestCode: Int, enterAnim: Int, outAnim: Int) {
            var intent = Intent(activity, clazz)
            activity.startActivityForResult(intent, requestCode)
            activity.overridePendingTransition(enterAnim, outAnim)
        }
    }

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

    open fun loadData() {}

    fun startAct(clazz: Class<*>): Unit {
        launch(this, clazz)
    }

    fun isActDestroy(): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return isFinishing || supportFragmentManager == null || supportFragmentManager.isDestroyed
        }
        return isFinishing || isDestroyed
    }

    open fun log(content: String) {
        if (BuildConfig.DEBUG) Log.d(TAG, content)
    }
}