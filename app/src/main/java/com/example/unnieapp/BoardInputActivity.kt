package com.example.unnieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sb_input.*

class BoardInputActivity : AppCompatActivity() {

    private val TAG = BoardInputActivity::class.java

    private var uid: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_input)

        if (intent.hasExtra("uid")) {
            uid = intent.getStringExtra("uid")
        }

        btn_wrtie_check.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = DataModel(
                uid.toString() ,
                txt_title.text.toString(),
                txt_content.text.toString()
            )
            myRef.child("board").push().setValue(dataInput)

            val intent = Intent(this,Sb_ListActivity::class.java)
            startActivity(intent)
        }
    }

}