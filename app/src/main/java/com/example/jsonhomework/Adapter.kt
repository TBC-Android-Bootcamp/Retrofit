package com.example.jsonhomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_recyclerview_layout.view.*

class Adapter(val itemList:MutableList<UserModel.Data>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private  lateinit var model:UserModel.Data

        fun onBind(){
            model=itemList[adapterPosition]
            itemView.tvUserId.text = model.id.toString()
            itemView.tvFirstName.text=model.firstName
            itemView.tvLastName.text=model.lastName
            itemView.tvEmail.text=model.email
            Glide.with(itemView.context).load(model.avatar).into(itemView.avatar)

        }
    }
}