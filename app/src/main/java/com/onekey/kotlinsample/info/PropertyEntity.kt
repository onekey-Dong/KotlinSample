package com.onekey.kotlinsample.info

/**
 * Created by onekey on 2019/6/20.
 */
class PropertyEntity(name: String) {

    var level: Int = 0
    val state = "PropertyEntity"
    var message = ""
    var date = ""

    constructor(level: Int) : this("") {
        this.level = level
    }

    override fun toString(): String {
        return "name:" + " >>> message:$message"
    }

    companion object {

        fun copyProperty(entity: PropertyEntity): PropertyEntity {
            var temp = PropertyEntity("name")
            temp.level = entity.level
            temp.date = entity.date
            temp.message = entity.message
            return temp
        }
    }
}