package com.jishnunkrishnan.test_loginretrofit

import android.R.*
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.activity_main.*

const val RC_SIGN_IN = 100
class MainActivity : AppCompatActivity() {

    private fun goToCourse(){

        startActivity(Intent(this, CourseListingActivity::class.java))
    }
    
    lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        JavaHelper.printHashKey(this)
        supportActionBar?.hide()

        /* Email Login End Start */
        val defaultEmail = "godwinjoe67@gmail.com"
        val defaultPassword = "123456"

        btnLogin.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            when {

                email.isEmpty() -> {

                    etEmail.error = "Enter Email"
                }
                password.isEmpty() -> {

                    etPassword.error = "Enter Password"
                }
                else -> {

                    if (email == defaultEmail && password == defaultPassword) {

                        goToCourse()
                    } else {

                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        /* Email Login End Here */

        /* Fb Login Start Here */
        btnFacebook.setOnClickListener {

            btnFacebook.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()

            LoginManager.getInstance().registerCallback(
                callbackManager,
                object : FacebookCallback<LoginResult> {

                    override fun onSuccess(result: LoginResult?) {

                        val graphRequest =
                            GraphRequest.newMeRequest(result?.accessToken) { obj, respose ->

                                try {
                                    if (obj.has("id")) {

                                        Log.i("Fb Data", obj.getString("name"))
                                        Log.i("Fb Data", obj.getString("email"))
                                        Log.i("Fb Data", obj.getString("picture"))
                                        goToCourse()
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

        /* Google Login Start*/
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        /* Google Login End*/

       // btnGoogle.setSize(SignInButton.SIZE_WIDE)

        btnGoogle.setOnClickListener {

            val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount = completedTask.getResult(ApiException::class.java)!!

            Toast.makeText(this, "Google login success", Toast.LENGTH_SHORT).show()
            val acct = GoogleSignIn.getLastSignedInAccount(this)
            if (acct != null) {
                val personName = acct.displayName
                val personGivenName = acct.givenName
                val personFamilyName = acct.familyName
                val personEmail = acct.email
                val personId = acct.id
                val personPhoto: Uri? = acct.photoUrl
                Toast.makeText(this, personName, Toast.LENGTH_SHORT).show()
                goToCourse()
            }
        } catch (e: ApiException) {

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        } else {

            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }
    /* Fb Login End Here */
}