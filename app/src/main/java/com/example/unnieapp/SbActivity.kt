package com.example.unnieapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.btn_previous
import kotlinx.android.synthetic.main.activity_school_board.*


class SbActivity : AppCompatActivity() {
    private val TAG = SbActivity::class.java.simpleName
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_board)


        auth = FirebaseAuth.getInstance()

        btn_write.setOnClickListener {
            val intent = Intent(this,BoardInputActivity::class.java)
            intent.putExtra("uid",auth.currentUser?.uid)
            startActivity(intent)
        }

        btn_previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}

