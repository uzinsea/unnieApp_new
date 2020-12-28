package com.example.unnieapp.chat

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.unnieapp.R
import kotlinx.android.synthetic.main.item_my_chat.view.chat_Text
import kotlinx.android.synthetic.main.item_my_chat.view.chat_Time
import kotlinx.android.synthetic.main.item_your_chat.view.*

class ChatAdapter(val context: Context, val arrayList: ArrayList<ChatModel>) :
    Adapter<ViewHolder>() {
    private lateinit var preferences: SharedPreferences

    fun addItem(item: ChatModel) {//아이템 추가
        arrayList.add(item)
    }

    override fun getItemViewType(position: Int): Int {//여기서 뷰타입을 1, 2로 바꿔서 지정해줘야 내채팅 너채팅을 바꾸면서 쌓을 수 있음
        preferences = context.getSharedPreferences("USERSIGN", Context.MODE_PRIVATE)
        //내 아이디와 arraylist의 name이 같다면 내꺼 아니면 상대꺼
        return if (arrayList.get(position).name == preferences.getString("name", "")) {
            1
        } else {
            2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View

        if (viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.item_my_chat, parent, false)
            return Holder(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_your_chat, parent, false)
            return Holder2(view)
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        //onCreateViewHolder에서 리턴받은 뷰홀더가 Holder라면 내채팅, item_my_chat의 뷰들을 초기화 해줌
        if (viewHolder is Holder) {
            viewHolder.chat_Text?.setText(arrayList.get(i).script)
            viewHolder.chat_Time?.setText(arrayList.get(i).date_time)
        }
        //onCreateViewHolder에서 리턴받은 뷰홀더가 Holder2라면 상대의 채팅, item_your_chat의 뷰들을 초기화 해줌
        else if (viewHolder is Holder2) {
            viewHolder.chat_You_Image?.setImageResource(R.mipmap.ic_launcher)
            viewHolder.chat_You_Name?.setText(arrayList.get(i).name)
            viewHolder.chat_Text?.setText(arrayList.get(i).script)
            viewHolder.chat_Time?.setText(arrayList.get(i).date_time)
        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    //내가친 채팅 뷰홀더
    inner class Holder(itemView: View) : ViewHolder(itemView) {
        //친구목록 모델의 변수들 정의하는부분
        val chat_Text = itemView.chat_Text
        val chat_Time = itemView.chat_Time
    }

    //상대가친 채팅 뷰홀더
    inner class Holder2(itemView: View) : ViewHolder(itemView) {

        //친구목록 모델의 변수들 정의하는부분
        val chat_You_Image = itemView.chat_You_Image
        val chat_You_Name = itemView.chat_You_Name
        val chat_Text = itemView.chat_Text
        val chat_Time = itemView.chat_Time
    }

}
