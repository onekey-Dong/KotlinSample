package com.onekey.kotlinsample.singleton

/**
 * Created by onekey on 2019/7/29.
 */
class InnerClassInstance private constructor() {

    companion object {

        fun get(): InnerClassInstance {
            return SingleHolder.holder
        }
    }

    private object SingleHolder {
        val holder = InnerClassInstance()
    }
}