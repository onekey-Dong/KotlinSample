package com.onekey.kotlinsample.base

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by onekey on 2019/6/20.
 */
abstract class BaseFragment : Fragment() {

    protected val TAG = this.tag

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var contentView = inflater!!.inflate(getContentViewID(), null)
        initView(contentView)
        return contentView
    }

    abstract fun getContentViewID() : Int

    abstract fun initView(contentView: View)

    final fun isActDestroy() : Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
            return activity.isFinishing || activity.supportFragmentManager == null || activity.supportFragmentManager.isDestroyed
        return activity.isFinishing || activity.isDestroyed
    }

    final fun showToast(msg : String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}