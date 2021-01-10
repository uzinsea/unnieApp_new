package com.example.unnieapp.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.unnieapp.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sb_input.*

class List_InputActivity : AppCompatActivity() {

    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_input)


        id = intent.getStringExtra("id").toString()


        btn_wrtie_check.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = DataModel(
                id,
                txt_title.text.toString(),
                txt_content.text.toString())
            myRef.child("board").push().setValue(dataInput)

            Toast.makeText(baseContext, "글이 작성되었습니다", Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(this, List_Sb_Activity::class.java)
            startActivity(intent)
        }
    }

}
