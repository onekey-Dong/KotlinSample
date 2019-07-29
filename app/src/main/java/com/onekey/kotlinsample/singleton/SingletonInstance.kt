package com.onekey.kotlinsample.singleton

/**
 * 线程安全的懒汉式单例。
 *
 * Created by onekey on 2019/7/29.
 */
class SingletonInstance private constructor() {

    companion object {

        private var instance : SingletonInstance? = null

        get() {
            if (field == null) {
                field = SingletonInstance()
            }
            return field
        }

        @Synchronized
        fun get() : SingletonInstance {
            return instance!!
        }
    }
}