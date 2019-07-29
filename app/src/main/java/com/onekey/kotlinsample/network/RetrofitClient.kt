package com.onekey.kotlinsample.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**
 * Created by onekey on 2019/6/20.
 */
class RetrofitClient private constructor() {

    private var mRetrofit : Retrofit? = null
    private var mBaseUrl : String? = null

    init {
        mRetrofit = Retrofit.Builder()
                .baseUrl("http://cdt0-openapi.taoshouyou.com/api/")
                .client(NetworkHttpClient.defaultConfig())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    companion object {

        private var mInstance : RetrofitClient? = null

            get() {
                if (field == null)
                    field = RetrofitClient()
                return field
            }

        @Synchronized
        fun get() : RetrofitClient {
            return mInstance!!
        }
    }

    fun <T> create(cls : Class<T>) : T {
        return mRetrofit!!.create(cls)
    }
}