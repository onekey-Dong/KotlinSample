package com.onekey.kotlinsample.tools

import android.util.Log
import com.orhanobut.logger.Logger

/**
 * Created by onekey on 19-6-19.
 */
class Tlog {

    companion object {

        fun e(msg : String) {
            Logger.e(msg)
        }

        fun d(msg: String) {
            Logger.d(msg)
        }

        fun i(msg: String) {
            Logger.i(msg)
        }

        fun e (tag : String , content : String) {
            Log.e(tag, content)
        }
    }
}