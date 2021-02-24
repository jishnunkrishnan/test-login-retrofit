package com.jishnunkrishnan.test_loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jishnunkrishnan.test_loginretrofit.network.EndPoint
import com.jishnunkrishnan.test_loginretrofit.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_course_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        supportActionBar?.hide()
        val intent = intent
        val id =intent.getStringExtra("id")
        val intId = id?.toInt()
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

        val retrofitClient = RetrofitClient(EndPoint.baseURL1)
        val apiResponseCall: Call<ResponseCourse> = retrofitClient.instance.getCourseDetails(intId!!)
        apiResponseCall.enqueue(object: Callback<ResponseCourse> {

            val exception = "Something happened to our end, please try again after sometimes!"

            override fun onResponse(call: Call<ResponseCourse>, response: Response<ResponseCourse>) {

                if (response.isSuccessful) {

                    val apiResponse = response.body()
                    if(apiResponse != null) {

                        Log.i("Error", apiResponse.data?.duration.toString())
                        Log.i("Error", apiResponse.data?.course_language.toString())
                        Log.i("Error", apiResponse.data?.course_like.toString())
                        Log.i("Error", apiResponse.data?.short_description.toString())
                        Log.i("Error", apiResponse.data?.specification.toString())
                        Log.i("Error", apiResponse.data?.course_image.toString())
                        Log.i("Error", apiResponse.data?.course_title.toString())

                        Log.i("Error asfa", apiResponse.toString())
                        ivCourseTitle.text = apiResponse.data?.course_title.toString()

                        Glide.with(applicationContext)
                            .load(apiResponse.data?.course_image)
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(ivCourseImages)
                        tvDuration.text =  apiResponse.data?.duration.toString()
                        tvLanguage.text = apiResponse.data?.course_language.toString()
                        tvLikes.text = apiResponse.data?.course_like.toString()
                        tvShortDesc.text = apiResponse.data?.short_description.toString()
                        tvSpec.text = apiResponse.data?.specification.toString()
                    }
                } else {

                    Log.i("Error afa", "asfas")
                }
            }

            override fun onFailure(call: Call<ResponseCourse>, t: Throwable) {

                Log.i("Error fd", t.toString())
            }
        })
    }
}