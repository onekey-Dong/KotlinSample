package com.onekey.kotlinsample

import android.support.v4.app.Fragment
import com.onekey.kotlinsample.base.BaseActivity
import com.onekey.kotlinsample.fragment.KotlinClassFragment
import com.onekey.kotlinsample.fragment.KotlinOneFragment
import com.onekey.kotlinsample.fragment.PropertyFrag

class KotlinActivity : BaseActivity() {

    override fun initView() {

        var index = intent.getIntExtra("index", 0)
        var fragment : Fragment? = null
        if (index == 0) {
            fragment = KotlinOneFragment.newInstance("one", "two")
        } else if (index == 1) {
            fragment = KotlinClassFragment.newInstance("", "")
        } else if (index == 2) {
            fragment = PropertyFrag.instance()
        }
        supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
    }

    override fun getContentViewID(): Int {
        return R.layout.activity_kotlin
    }
}
