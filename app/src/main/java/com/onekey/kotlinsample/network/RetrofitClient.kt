package com.onekey.kotlinsample.network

import retrofit2.Retrofit

/**
 * Created by onekey on 2019/6/20.
 */
class RetrofitClient private constructor() {

    private var mRetrofit : Retrofit? = null
    private var mBaseUrl : String? = null

    constructor(url: String) : this() {

    }

    companion object {

        private var mIntance : RetrofitClient? = null

        fun instance(url: String) : RetrofitClient? {
            if (mIntance == null) {
                synchronized(RetrofitClient::class) {
                    if (mIntance == null)
                        mIntance = RetrofitClient(url)
                }
            }
            return mIntance
        }

    }


    fun instance(baseUrl : String) : RetrofitClient? {
        return null
    }
}