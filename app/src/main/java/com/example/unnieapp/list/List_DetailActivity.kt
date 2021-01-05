package com.example.unnieapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.unnieapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sb_detail.*

class List_DetailActivity : AppCompatActivity() {
    var id: String = ""
    var w_id: String = ""
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_detail)

        id = intent.getStringExtra("now_id")!!
        w_id = intent.getStringExtra("id").toString()
        d_id.text = intent.getStringExtra("id").toString()
        d_result_title.text = intent.getStringExtra("title")
        d_result_contents.text = intent.getStringExtra("contents")

        Log.d("wid", w_id.toString())
        //  아이디 동일 할 때 수정,삭제 버튼 나타나게 하기!!

        if (w_id == id) {
            Toast.makeText(baseContext, "id가 동일합니다", Toast.LENGTH_SHORT).show()
            btn_modify.visibility = View.VISIBLE
            btn_delete.visibility = View.VISIBLE

            btn_delete.setOnClickListener {

            }
        }

    }
}