package com.example.unnieapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.unnieapp.chat.ChatroomActivity
import com.example.unnieapp.list.List_Sb_Activity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //sharedPreferences 데이터를 영구 저장하는 방법으로는 SharedPreferences(쉐어드프리퍼런스)가 있다.
    // App에 포함되는 데이터 파일을 만들어서, 디바이스에 저장하는 방식이다.
    private lateinit var preferences: SharedPreferences
    private lateinit var auth: FirebaseAuth


    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        preferences = getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)
        val editor = preferences.edit()

        //버튼을 클릭하면 입력한 이름을 쉐어드프리퍼런스에 내이름을 저장한다.
        //또한 그 이름을 가지고 채팅방으로 이동한다.
        btn_chat.setOnClickListener {
            val intent = Intent(this, ChatroomActivity::class.java)
            startActivity(intent)
        }

        btn_login.setOnClickListener {
            id = intent.getStringExtra("id").toString()
            if (id == "null") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginDetailActivity::class.java)
                intent.putExtra("id", auth.currentUser?.email)
                startActivity(intent)
            }

        }
        btn_school.setOnClickListener {
            id = intent.getStringExtra("id").toString()
            if(id == "null"){
                Toast.makeText(baseContext,"로그인 후 이용하세요",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, List_Sb_Activity::class.java)
                startActivity(intent)
            }

        }


    }
}
