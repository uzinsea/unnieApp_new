package com.example.unnieapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.btn_previous
import kotlinx.android.synthetic.main.activity_sb.*


class SbActivity : AppCompatActivity() {
    private val TAG = SbActivity::class.java.simpleName
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val title_array = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb)


        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference().child("board")

        btn_write.setOnClickListener {
            val intent = Intent(this, BoardInputActivity::class.java)
            intent.putExtra("uid", auth.currentUser?.uid)
            startActivity(intent)
        }

        val list_adapter = listAdapter(this, title_array)
        listview.adapter = list_adapter

        database.addValueEventListener(object : ValueEventListener {
            //실패했을때
            override fun onCancelled(dataSnapshot: DatabaseError) {
            }

            //성공했을때
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    val modelResult = data.getValue(DataModel::class.java)
                    title_array.add(modelResult?.title.toString())
                }
                list_adapter.notifyDataSetChanged()
            }
        })

        btn_previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}

