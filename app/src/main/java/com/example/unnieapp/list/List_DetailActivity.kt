package com.example.unnieapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unnieapp.R
import kotlinx.android.synthetic.main.activity_sb_detail.*

class List_DetailActivity : AppCompatActivity() {
    private var item: String = ""
    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_detail)

        id = intent.getStringExtra("id").toString()
        item = intent.getStringExtra("title").toString()

        d_id.text = id
        d_result_title.text = item



    }
}