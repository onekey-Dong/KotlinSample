package com.onekey.kotlinsample.tools

import com.google.gson.Gson
import java.util.*

/**
 * Created by onekey on 2019/6/20.
 */
class GsonTool private constructor() {

    companion object {

        fun <T> toObject(data: String, clazz: Class<T>): T {
            var gson = Gson()
            return gson.fromJson<T>(data, clazz)
        }

        fun toString(objects: Objects): String {
            var gson = Gson()
            return gson.toJson(objects)
        }
    }
}