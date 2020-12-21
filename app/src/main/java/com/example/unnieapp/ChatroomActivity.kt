package com.example.unnieapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chatroom.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChatroomActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    //리사이클러뷰
    private val arrayList = ArrayList<String>()

    private val mAdapter = ChatAdapter(this, arrayList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        preferences = getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)

        //어댑터 선언
        chat_recyclerview.adapter = mAdapter
        //레이아웃 매니저  ??
        val lm = LinearLayoutManager(this)
        chat_recyclerview.layoutManager = lm
        chat_recyclerview.setHasFixedSize(true)

        chat_Send_Button.setOnClickListener {
            sendMessage()
        }

    }

    private fun sendMessage() {
        val now = System.currentTimeMillis()
        val date = Date(now)
        val sdf = SimpleDateFormat("yyyy-mm-dd")
        val getTime = sdf.format(date)

        val item = ChatModel(
            preferences.getString("name", "")!!,
            chating_Text.text.toString(),
            "example",
            getTime
        )
        mAdapter.addItem(item)
        mAdapter.notifyDataSetChanged()

        //채팅 입력창 초기화
        chating_Text.setText("")
    }
}

