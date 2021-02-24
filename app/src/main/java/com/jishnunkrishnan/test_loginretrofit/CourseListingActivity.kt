package com.jishnunkrishnan.test_loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import com.jishnunkrishnan.test_loginretrofit.network.EndPoint
import com.jishnunkrishnan.test_loginretrofit.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_course_listing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseListingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_listing)

        val retrofitClient = RetrofitClient(EndPoint.baseURL1)
        val apiResponseCall: Call<ResponseModel> = retrofitClient.instance.getCourse()
        apiResponseCall.enqueue(object: Callback<ResponseModel> {

            val exception = "Something happened to our end, please try again after sometimes!"

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                if (response.isSuccessful) {

                    val apiResponse = response.body()
                    if(apiResponse != null) {

                        Log.i("Error", apiResponse.data?.get(0)?.course_title.toString())
                        Log.i("Error", apiResponse.data?.get(0)?.course_price.toString())
                        Log.i("Error", apiResponse.data?.get(0)?.trainer.toString())
                        Log.i("Error", apiResponse.data?.get(0)?.trainer_img.toString())
                        Log.i("Error", apiResponse.data?.get(0)?.course_image.toString())
                        Log.i("Error", apiResponse.data?.get(0)?.course_like.toString())
                        val list = CourseListAdapter(apiResponse, applicationContext)
                        rvCourse.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
                        rvCourse.setHasFixedSize(true)
                        rvCourse.adapter = list
                    }
                } else {

                    Log.i("Error", "asfas")
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

               Log.i("Error", t.toString())
            }
        })

    }
}