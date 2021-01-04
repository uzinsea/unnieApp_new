package com.example.unnieapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unnieapp.R
import kotlinx.android.synthetic.main.activity_sb_detail.*
import kotlinx.android.synthetic.main.activity_sb_list.*

class List_DetailActivity : AppCompatActivity() {
    private var item: String = ""
    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_detail)

        d_id.setText(intent.getStringExtra("id"))
        d_result_title.setText(intent.getStringExtra("title"))
        d_result_contents.setText(intent.getStringExtra("contents"))



    }
}