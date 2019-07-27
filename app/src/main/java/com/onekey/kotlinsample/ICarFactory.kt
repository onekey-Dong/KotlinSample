package com.onekey.kotlinsample

import com.onekey.kotlinsample.entity.Car

/**
 * Created by onekey on 2019/7/27.
 */
interface ICarFactory {

    open fun createCar(date : String) : Car

    fun destroyCar() : Unit
}