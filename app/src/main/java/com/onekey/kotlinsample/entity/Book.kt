package com.onekey.kotlinsample.entity

/**
 * Created by onekey on 19-6-19.
 */
class Book(var name: String) {

    var date : String = ""

    constructor(date : String, name: String) : this("") {
        this.date = date
    }
}