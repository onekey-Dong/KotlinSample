package com.onekey.kotlinsample.tools

/**
 * Created by onekey on 2019/7/27.
 */
class StringTool private constructor() {

    companion object {

        fun uniteStringFromList(list: List<String>): String {
            var bulder = StringBuilder()
            for (s in list)
                bulder.append(s)
            return bulder.toString()
        }
    }
}