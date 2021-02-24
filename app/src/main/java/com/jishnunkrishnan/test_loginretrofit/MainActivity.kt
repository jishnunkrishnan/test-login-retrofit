package com.jishnunkrishnan.test_loginretrofit

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JavaHelper.printHashKey(this)
        supportActionBar?.hide()

        /* Email Login End Start */
        var defaultEmail = "godwinjoe67@gmail.com"
        var defaultPassword = "123456"

        btnLogin.setOnClickListener {

            var email = etEmail.text.toString()
            var password = etPassword.text.toString()

            when {

                email.isNullOrEmpty() -> {

                    etEmail.error = "Enter Email"
                }
                password.isNullOrEmpty() -> {

                    etPassword.error = "Enter Password"
                }
                else -> {

                    if (email == defaultEmail && password == defaultPassword) {

                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                    } else {

                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        /* Email Login End Here */

        btnFacebook.setOnClickListener {

            btnFacebook.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()

            LoginManager.getInstance().registerCallback(callbackManager, object: FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult?) {

                    val graphRequest = GraphRequest.newMeRequest(result?.accessToken) { obj, respose ->

                        try {

                            if (obj.has("id")) {

                                Log.i("Fb Data", obj.getString("name"))
                                Log.i("Fb Data", obj.getString("email"))
                                Log.i("Fb Data", obj.getString("picture"))
                            }
                        } catch (e: Exception) {

                        }
                    }

                    val param = Bundle()
                    param.putString("fields", "name, email, id, picture.type(large)")
                    graphRequest.parameters = param

                    graphRequest.executeAsync()
                }

                override fun onCancel() {

                }

                override fun onError(error: FacebookException?) {

                }
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}