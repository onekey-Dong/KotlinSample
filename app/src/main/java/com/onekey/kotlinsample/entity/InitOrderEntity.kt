package com.onekey.kotlinsample.entity

/**
 * Created by onekey on 19-6-19.
 */
class InitOrderEntity constructor (name: String = "defaultValue") {

    val firstProperty = "first property >>> $name".also (:: println)
    val upperCaseName = name.toUpperCase()

    init {
        "first init name >>> $name".also (:: println)
    }

    val secondProperty = "second property >>> ${name.length}".also (:: println)

    init {
         "second init >>> ${name.length}".also(:: println)
    }

    constructor(time: Int, name: String) : this (name) {
        "time is $time".also (:: println)
    }

    init {
       "$firstProperty <<= property =>> $secondProperty upperCase ==> $upperCaseName".also (:: println)
    }
}