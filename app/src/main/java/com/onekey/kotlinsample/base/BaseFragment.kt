package com.onekey.kotlinsample.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by onekey on 2019/6/20.
 */
abstract class BaseFragment() : Fragment() {

    protected val TAG = this.tag;

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var contentView = inflater!!.inflate(getContentViewID(), null)
        initView(contentView)
        return contentView
    }

    abstract fun getContentViewID() : Int

    abstract fun initView(contentView: View)
}