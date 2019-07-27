package com.onekey.kotlinsample.base

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.onekey.kotlinsample.tools.Tlog

/**
 * Created by onekey on 2019/6/20.
 */
abstract class BaseFragment : Fragment() {

    protected val TAG = javaClass.simpleName

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var contentView = inflater!!.inflate(getContentViewID(), null)
        initView(contentView)
        return contentView
    }

    abstract fun getContentViewID() : Int

    abstract fun initView(contentView: View)

    // 默认的方法不允许子类复写。
    protected fun isActDestroy() : Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
            return activity.isFinishing || activity.supportFragmentManager == null || activity.supportFragmentManager.isDestroyed
        return activity.isFinishing || activity.isDestroyed
    }

    open fun showToast(msg : String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    // open 关键字，允许子类复写该方法。
    open fun log(content : String) : Unit {
        Tlog.e(TAG, content)
    }
}