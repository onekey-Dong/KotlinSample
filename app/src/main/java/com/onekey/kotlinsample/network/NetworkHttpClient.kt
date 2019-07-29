package com.onekey.kotlinsample.network

import android.util.Log
import com.onekey.kotlinsample.BuildConfig
import com.onekey.kotlinsample.tools.Tlog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by onekey on 2019/6/20.
 */
class NetworkHttpClient private constructor() {

    companion object {

        private var TAG : String? = javaClass.simpleName

        fun defaultConfig() : OkHttpClient {
            var builder = OkHttpClient.Builder()
                    .readTimeout(25, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(25, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                var interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message: String? ->  Log.d(TAG, message)})
                interceptor.level = HttpLoggingInterceptor.Level.BASIC
                builder.addInterceptor(interceptor)
            }
            return builder.build()
        }

        fun createHttpClient(builder : OkHttpClient.Builder) : OkHttpClient {
            return builder.build()
        }
    }
}