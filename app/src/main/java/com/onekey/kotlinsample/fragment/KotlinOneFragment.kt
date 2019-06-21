package com.onekey.kotlinsample.fragment

import android.os.Bundle
import android.support.v7.widget.AppCompatTextView
import android.view.View
import com.google.gson.Gson
import com.onekey.kotlinsample.R
import com.onekey.kotlinsample.base.BaseFragment
import com.onekey.kotlinsample.bean.BaseHttpEntity
import com.onekey.kotlinsample.bean.HomeEntity
import com.onekey.kotlinsample.network.RetrofitClient
import com.onekey.kotlinsample.tools.GsonTool
import com.onekey.kotlinsample.tools.Tlog

/**
 */
class KotlinOneFragment : BaseFragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
            showToast(mParam1 + mParam2)
        }
    }

    override fun getContentViewID(): Int {
        return R.layout.fragment_kotlin_one
    }

    override fun initView(contentView: View) {
        var tipOne = contentView.findViewById<AppCompatTextView>(R.id.tvKotlinOneFirstTip)
        var tipTwo = contentView.findViewById<AppCompatTextView>(R.id.tvKotlinOneSecondTip)

        tipOne.setText("modify one time")
        tipTwo.setText("modify two twice")

        var home = HomeEntity()
        home.result = "Home"
        home.time = 22
        var entity = BaseHttpEntity<HomeEntity>(home)
        entity.errCode = 100
        entity.errMsg = "Json解析"

        var gson = Gson()
        var json = gson.toJson(entity)

        var objectData = gson.fromJson<BaseHttpEntity<HomeEntity>>(json, BaseHttpEntity::class.javaObjectType)
        Tlog.e(json)
        Tlog.e(objectData.errMsg)
        Tlog.e(GsonTool.toObject(json, BaseHttpEntity::class.javaObjectType).errMsg)

        Tlog.e((RetrofitClient.instance("") == RetrofitClient.instance("")).toString())
    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): KotlinOneFragment {
            val fragment = KotlinOneFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
