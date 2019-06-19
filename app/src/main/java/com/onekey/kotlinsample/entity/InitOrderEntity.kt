package com.onekey.kotlinsample.entity

import com.onekey.kotlinsample.tools.Tlog

/**
 * Created by onekey on 19-6-19.
 */
class InitOrderEntity (name: String) {

    val firstProperty = "first property >>> $name".also (:: println)

    init {
        Tlog.e("first init name >>> $name")
    }

    val secondProperty = "second property >>> ${name.length}"

    init {
        Tlog.e((name is String).toString() + " second property >>> ${name.length}")
    }

    class InnerEntity {
        
    }
}