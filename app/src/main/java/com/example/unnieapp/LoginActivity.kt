package com.example.unnieapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity() {

    //start declare auth
    private lateinit var auth: FirebaseAuth
    private val TAG = "EmailPassword"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        val email = user_email
        val password = user_pwd

        btn_signin.setOnClickListener {
            if (email.text.toString().length == 0 || password.text.toString().length == 0){
                Toast.makeText(this, "email 혹은 password를 반드시 입력하세요", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInWithEmail:success")
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            }
        }
        btn_signup.setOnClickListener {
            if (email.text.toString().length == 0 || password.text.toString().length == 0){
                Toast.makeText(this, "email 혹은 password를 반드시 입력하세요", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if(task.isSuccessful){
                            Toast.makeText(baseContext, "Authentication Success", Toast.LENGTH_SHORT)
                                .show()
                            Log.w(TAG, "signUpWithEmail:success", task.exception)
                            Log.d(TAG, "signUpWithEmail:success")

                        } else{
                            Toast.makeText(baseContext, "Authentication failed", Toast.LENGTH_SHORT)
                                .show()
                            Log.w(TAG, "signUpWithEmail:failure", task.exception)

                        }
                    }
            }
        }

        btn_previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

