package com.onekey.kotlinsample

import com.onekey.kotlinsample.entity.Car

/**
 * Created by onekey on 2019/7/27.
 */
interface ICarPerson {

    open fun driveCar(car: Car) : Unit

    open fun cleanCar() : Boolean
}