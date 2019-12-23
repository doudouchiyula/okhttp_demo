package com.zhm.example.kt_learn191218

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MessageAdapter(context: Context, list: MutableList<MessageBean>?) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private var alist: MutableList<MessageBean>
    private var context: Context

    init {
        this.alist = list ?: mutableListOf()
        this.context = context

    }

    fun resetData(list: List<MessageBean>) {
        alist.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapter.ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.item_message, null)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return alist.size
    }


    override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) {
        val messageBean = alist.get(position)
        holder.tvContent.setText(messageBean.content)
        holder.tvTag.setText(messageBean.tag)
        Glide.with(context).load(messageBean.picUrl).into(holder.ivIcon)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTag: TextView by lazy { itemView.findViewById<TextView>(R.id.tv_tag) }
        val tvContent: TextView by lazy { itemView.findViewById<TextView>(R.id.tv_content) }
        val ivIcon: ImageView by lazy { itemView.findViewById<ImageView>(R.id.iv_icon) }
    }
}