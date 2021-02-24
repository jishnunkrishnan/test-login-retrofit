package com.jishnunkrishnan.test_loginretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}