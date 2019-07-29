package com.onekey.kotlinsample.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.onekey.kotlinsample.R
import com.onekey.kotlinsample.base.BaseFragment
import com.onekey.kotlinsample.entity.Car
import com.onekey.kotlinsample.entity.Person
import com.onekey.kotlinsample.network.INetService
import com.onekey.kotlinsample.network.RetrofitClient
import com.onekey.kotlinsample.singleton.InnerClassInstance
import com.onekey.kotlinsample.singleton.SingletonInstance
import com.onekey.kotlinsample.tools.StringTool
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer

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
        var ch : Char = 'a'
        log(ch.toString())
        log(ch.toInt().toString())

        var content : String = "tangxiangdong"
        log(content[1].toString())
        for (c in content)
            log(c.toString())

        var list = ArrayList<String>()
        list.add("one")
        list.add("two")
        list.add("three")
        StringTool.uniteStringFromList(list)

        var one = "10"
        log("one = $one")
        var two = "two"
        log("two = $two, lenth = ${two.length}")

        var arr = arrayOf(1, 90, 100, 299)

        var arrTwo  = arrayOf("one", "three", "six", "ten")
        for (a in arr)
            log(a.toString())
        for (s in arrTwo)
            log(s)

        var car = Car("one")
        log(car.name + " >>> " + car.date)
        var carList = ArrayList<Car.CarItem>()
        carList.add(Car().CarItem("111222333"))

        var person = Person("Tony", 18)
        var smallCar = Car("small car")
        person.driveCar(smallCar)
        person.cleanCar()
        log((person is Person).toString())

        for (i in 10..15) // i 从10 到15.
            log("i > " + i)

        val intArr = arrayOf(20, 30, 40, 50)
        for (i in intArr.indices) // 此处i为index角标。
            log("arr $i = ${intArr[i]}")

        var index = 10
        do {
            log("index : $index" )
            index++
        } while (index < 15)

        for (i in 10 downTo 20)
            log("until : $i")

        for (i in 1 downTo 5 step 2) {
            log("downTo $i")
        }

        log((SingletonInstance.get() === SingletonInstance.get()).toString())
        SingletonInstance.get()

        log(person.property)
        person.property = "test-set"
        log(person.property)

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
