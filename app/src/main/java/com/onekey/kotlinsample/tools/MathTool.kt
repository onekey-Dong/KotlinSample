package com.onekey.kotlinsample.tools

/**
 * Created by onekey on 19-6-19.
 */
class MathTool private constructor() {

    companion object {

        fun add(a: Int, b: Int) = a + b

        fun reduce(a: Int, b: Int) = a - b
    }
}