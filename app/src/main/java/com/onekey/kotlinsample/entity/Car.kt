package com.onekey.kotlinsample.entity

import com.onekey.kotlinsample.tools.Tlog
import java.util.*

/**
 * Created by onekey on 2019/7/27.
 */
class Car constructor (name : String = "大众", date : String = "2019.10.1") {

    // name , date 为默认值。当直接调用Car() 时。

    var name : String  = ""
    var date : String = ""
    var itemList : LinkedList<CarItem>?  = null

    init {
        this.name = name
        this.date = date
        Tlog.e(name + date)
    }

    constructor(name : String) : this (name, "2018")

    fun getString() : String {
        return ""
    }

    public inner class CarItem (itemName : String) {

        var itemName : String? = null

        init {
            this.itemName = itemName
        }
    }
}