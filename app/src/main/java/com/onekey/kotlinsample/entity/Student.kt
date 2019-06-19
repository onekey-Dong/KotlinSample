package com.onekey.kotlinsample.entity

/**
 * Created by onekey on 19-6-19.
 */
abstract class Student {

    var name = ""
    var age = 0

    abstract fun eat(content : String)

    abstract fun read(book: Book)
}