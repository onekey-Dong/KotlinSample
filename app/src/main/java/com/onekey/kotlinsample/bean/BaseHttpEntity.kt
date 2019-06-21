package com.onekey.kotlinsample.bean

/**
 * Created by onekey on 2019/6/20.
 */
class BaseHttpEntity<T>(var data : T) {

    var errMsg : String = ""
    var errCode : Int = 0
}