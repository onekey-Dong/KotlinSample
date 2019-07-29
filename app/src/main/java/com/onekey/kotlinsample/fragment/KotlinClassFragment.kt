package com.onekey.kotlinsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.onekey.kotlinsample.R
import com.onekey.kotlinsample.base.BaseFragment
import com.onekey.kotlinsample.entity.Car
import com.onekey.kotlinsample.entity.InitOrderEntity
import com.onekey.kotlinsample.entity.Person
import com.onekey.kotlinsample.network.INetService
import com.onekey.kotlinsample.network.RetrofitClient
import com.onekey.kotlinsample.singleton.SingletonInstance
import com.onekey.kotlinsample.tools.StringTool
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * 学习kotlon类的使用。
 */
class KotlinClassFragment : BaseFragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(KEY_ONE)
            mParam2 = arguments.getString(KEY_TWO)
        }
    }

    override fun getContentViewID(): Int {
        return R.layout.fragment_kotlin_class
    }

    override fun initView(contentView: View) {

        log((SingletonInstance.get() === SingletonInstance.get()).toString())
        SingletonInstance.get()

        RetrofitClient.get()
                .create(INetService::class.java)
                .preferenceSetting()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<String> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: String) {
                        log(t)
                    }

                    override fun onComplete() {
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })

        InitOrderEntity(10,"Tony")

        InitOrderEntity()
    }

    override fun log(content: String) {
        Log.e(TAG, content)
    }

    companion object {

        const val KEY_ONE = "key_one"// 外部可调用常量声明方法。
        private const val KEY_TWO = "key_two"

        fun newInstance(param1: String, param2: String): KotlinClassFragment {
            val fragment = KotlinClassFragment()
            val args = Bundle()
            args.putString(KEY_ONE, param1)
            args.putString(KEY_TWO, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
