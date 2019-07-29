package com.onekey.kotlinsample.fragment


import android.support.v4.app.Fragment
import android.view.View
import com.onekey.kotlinsample.R
import com.onekey.kotlinsample.base.BaseFragment
import com.onekey.kotlinsample.entity.Car
import com.onekey.kotlinsample.entity.Person
import com.onekey.kotlinsample.tools.StringTool


/**
 * A simple [Fragment] subclass.
 */
class PropertyFrag : BaseFragment() {

    companion object {

        fun instance() : PropertyFrag {
            var frag = PropertyFrag()
            return frag
        }
    }

    override fun getContentViewID(): Int {
        return R.layout.fragment_property
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

        log(person.property)
        person.property = "test-set"
        log(person.property)
    }


}// Required empty public constructor
