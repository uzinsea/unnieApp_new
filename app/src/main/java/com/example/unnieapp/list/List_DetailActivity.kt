package com.example.unnieapp.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.unnieapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sb_detail.*

class List_DetailActivity : AppCompatActivity() {
    var id: String = ""
    var w_id: String = ""
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_detail)
        database = FirebaseDatabase.getInstance().getReference().child("board")

        id = intent.getStringExtra("now_id")!!
        w_id = intent.getStringExtra("id").toString()
        d_id.text = intent.getStringExtra("id").toString()
        d_result_title.text = intent.getStringExtra("title")
        d_result_contents.text = intent.getStringExtra("contents")

        Log.d("wid", w_id.toString())
        //  아이디 동일 할 때 수정,삭제 버튼 나타나게 하기!!

        if (w_id == id) {
            btn_modify.visibility = View.VISIBLE
            btn_delete.visibility = View.VISIBLE

            btn_delete.setOnClickListener {
//                database.child("board")
                Toast.makeText(baseContext, "삭제되었습니다", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, List_Sb_Activity::class.java)
                startActivity(intent)
            }
        }

    }
}