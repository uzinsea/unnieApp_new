package com.example.unnieapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


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
                            Toast.makeText(baseContext, "로그인에 성공하셨습니다", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this, MainActivity::class.java)
                            intent.putExtra("id", auth.currentUser?.email)
                            startActivity(intent)
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "로그인에 실패하셨습니다", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            }
        }

        btn_signup.setOnClickListener {
            val intent = Intent(this,Login_SignUpActivity::class.java)
            startActivity(intent)
        }

        btn_previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

