package com.onekey.kotlinsample.network

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by onekey on 2019/7/29.
 */
interface INetService {

    @GET("user-preference/get-switch-status")
    fun preferenceSetting(): Observable<String>
}