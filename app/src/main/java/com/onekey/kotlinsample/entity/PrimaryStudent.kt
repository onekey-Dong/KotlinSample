package com.onekey.kotlinsample.entity

import com.onekey.kotlinsample.tools.Tlog

/**
 * Created by onekey on 19-6-19.
 */
class PrimaryStudent(name: String, age: Int) : Student() {

    constructor(name: String) : this(name, 0)

    constructor(age: Int) : this("", age)

    override fun eat(content: String) {
        Tlog.e(name  + "正在吃$content")
    }

    override fun read(book: Book) {
        Tlog.e(book.name)
    }

    fun read(name: String) {
        read(Book(name, "2018=10").date)
    }

    init {
        super.name = name
        super.age = age
    }

}