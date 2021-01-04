package com.example.unnieapp.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.unnieapp.MainActivity
import com.example.unnieapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.btn_previous
import kotlinx.android.synthetic.main.activity_sb_input.*
import kotlinx.android.synthetic.main.activity_sb_list.*


class List_Sb_Activity : AppCompatActivity() {
    private val TAG = List_Sb_Activity::class.java.simpleName

    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val title_array = ArrayList<String>()
    private val contents_array = ArrayList<String>()
    private val id_array = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sb_list)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference().child("board")

        //글쓰기 버튼 누를 때
        btn_write.setOnClickListener {
            val intent = Intent(this, List_InputActivity::class.java)
            intent.putExtra("uid", auth.currentUser?.uid)
            intent.putExtra("id", auth.currentUser?.email)
            startActivity(intent)
        }

        val list_adapter = ListAdapter(this, title_array, contents_array, id_array)

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
                    contents_array.add(modelResult?.contents.toString())
                    id_array.add(modelResult?.id.toString())
                }
                list_adapter.notifyDataSetChanged()
            }
        })

        //리스트뷰 아이템 클릭시
        listview.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->

            val intent = Intent(this, List_DetailActivity::class.java)
            intent.putExtra("id",id_array.get(position))
            intent.putExtra("title",title_array.get(position))
            intent.putExtra("contents",contents_array.get(position) )


            startActivity(intent)
        }
//
//        btn_delete.setOnClickListener {
//            database = FirebaseDatabase.getInstance().getReference().child("board")
//            database.removeValue().addOnSuccessListener {
//                Toast.makeText(baseContext, "글이 삭제되었습니다", Toast.LENGTH_SHORT).show()
//            }.addOnFailureListener {
//                Toast.makeText(baseContext, "글 삭제가 실패되었습니다", Toast.LENGTH_SHORT).show()
//            }
//        }


        btn_previous.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}

