package com.jishnunkrishnan.test_loginretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.JsonObject
import com.jishnunkrishnan.test_loginretrofit.network.EndPoint
import com.jishnunkrishnan.test_loginretrofit.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_course_listing.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseListingActivity : AppCompatActivity(), CourseListAdapter.GoToCourse {
    lateinit var toggle: ActionBarDrawerToggle

    override fun goToCourseDetails(id: String) {

        val intent = Intent(this, CourseDetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_listing)

        title = "Dashboard"

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, CourseListingActivity::class.java))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.logout -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

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
                        val list = CourseListAdapter(apiResponse, applicationContext, this@CourseListingActivity)
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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}