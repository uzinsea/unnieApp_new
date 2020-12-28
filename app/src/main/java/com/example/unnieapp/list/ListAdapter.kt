package com.example.unnieapp.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.unnieapp.R

class ListAdapter(val context: Context, val list: ArrayList<String>,val list2 : ArrayList<String>)
    : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.listview_item,null)

        val titleView: TextView = rootView.findViewById(R.id.result_title)
        val contentsView: TextView = rootView.findViewById(R.id.result_contents)

        titleView.text = list[position]
        contentsView.text = list2[position]
        return rootView

    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }
}