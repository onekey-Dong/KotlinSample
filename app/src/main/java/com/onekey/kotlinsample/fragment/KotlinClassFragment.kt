package com.onekey.kotlinsample.fragment

import android.os.Bundle
import android.view.View
import com.onekey.kotlinsample.R
import com.onekey.kotlinsample.base.BaseFragment
import com.onekey.kotlinsample.entity.Car
import com.onekey.kotlinsample.entity.Person
import com.onekey.kotlinsample.tools.StringTool
import com.orhanobut.logger.Logger

/**
 * 学习kotlon类的使用。
 */
class KotlinClassFragment : BaseFragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
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

        var list : ArrayList<String> = ArrayList()
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
    }

    override fun log(content: String) {
        Logger.e(content)
    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): KotlinClassFragment {
            val fragment = KotlinClassFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
