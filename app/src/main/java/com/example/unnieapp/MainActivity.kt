package com.example.unnieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{

        }

        fun loadData(): MutableList<Post> {
            val data: MutableList<Post> = mutableListOf()

            for (i in 0 until 5){
                val head = "[인기글]"
                val title = "게시글 입니다"
                var post = Post(head, title)
                data.add(post)
            }
            return data;
        }
    }
}
