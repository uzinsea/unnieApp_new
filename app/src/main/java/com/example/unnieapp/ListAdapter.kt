package com.example.unnieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sb.view.*
import kotlinx.android.synthetic.main.listview_item.view.*

class ListAdapter(val context: Context, val list: ArrayList<String>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item,null)
        //database = FirebaseDatabase.getInstance().getReference().child("board")
//어댑터만 고치면 될 거같은데 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
        return view
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getCount(): Int {
        return 3
    }
}