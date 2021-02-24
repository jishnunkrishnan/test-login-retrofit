package com.jishnunkrishnan.test_loginretrofit.network

import com.jishnunkrishnan.test_loginretrofit.ResponseCourse
import com.jishnunkrishnan.test_loginretrofit.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @GET(EndPoint.getCourse)
    fun getCourse(): Call<ResponseModel>

    @GET(EndPoint.getCourseDetail+ "/{id}")
    fun getCourseDetails(@Path("id") id: Int): Call<ResponseCourse>



}