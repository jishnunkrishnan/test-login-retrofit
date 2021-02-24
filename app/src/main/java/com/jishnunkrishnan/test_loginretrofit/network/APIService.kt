package com.jishnunkrishnan.test_loginretrofit.network

import com.jishnunkrishnan.test_loginretrofit.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET(EndPoint.getCourse)
    fun getCourse(): Call<ResponseModel>
}