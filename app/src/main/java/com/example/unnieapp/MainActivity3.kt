package com.example.unnieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

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
