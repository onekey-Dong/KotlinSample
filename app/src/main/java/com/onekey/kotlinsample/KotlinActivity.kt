package com.onekey.kotlinsample

import com.onekey.kotlinsample.base.BaseActivity
import com.onekey.kotlinsample.fragment.KotlinOneFragment

class KotlinActivity : BaseActivity() {

    override fun initView() {
        var fragment = KotlinOneFragment()

        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
    }

    override fun getContentViewID(): Int {
        return R.layout.activity_kotlin
    }
}
