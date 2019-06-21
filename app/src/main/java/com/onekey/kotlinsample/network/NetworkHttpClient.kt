package com.onekey.kotlinsample.network

import com.onekey.kotlinsample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by onekey on 2019/6/20.
 */
class NetworkHttpClient private constructor() {

    companion object {

        private var TAG : String? = NetworkHttpClient::class.simpleName

        fun defaultConfig() : OkHttpClient {
            var builder = OkHttpClient.Builder()
                    .readTimeout(25, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(25, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                var interceptor = HttpLoggingInterceptor()
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