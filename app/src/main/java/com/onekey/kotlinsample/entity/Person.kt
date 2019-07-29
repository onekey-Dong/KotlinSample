package com.onekey.kotlinsample.entity

import com.onekey.kotlinsample.ICarPerson
import com.onekey.kotlinsample.tools.Tlog

/**
 * Created by onekey on 2019/7/27.
 */
class Person (name: String, age : Int) : ICarPerson {

    var name : String? = null
    var age : Int? = null

    init {
        this.name = name
        this.age = age
    }

    override fun driveCar(car: Car) {
        Tlog.e(name + " is driving " + car.name)
    }

    override fun cleanCar(): Boolean {
        return false
    }

    var property : String = "123"

    get() {
        return "no-value"
        //return field
    }

    set(value) {
        field = "no-set-action"
    }
}