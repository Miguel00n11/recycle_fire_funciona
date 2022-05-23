package com.example.recycleryfirebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private  val userlist:ArrayList<User>):RecyclerView.Adapter<MyAdapter.MyViewHolder> (){






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.user_item,
       parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem=userlist[position]
        holder.raza.text=currentitem.raza
        holder.color.text=currentitem.color

//        val currentitem=userlist[position]
//        holder.firstName.text=currentitem.firstName
//        holder.lastName.text=currentitem.lastName
//        holder.age.text=currentitem.age.toString()


    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val raza:TextView=itemView.findViewById(R.id.tvfirstname)
        val color:TextView=itemView.findViewById(R.id.tvlastname)
        val age:TextView=itemView.findViewById(R.id.tvAge)

    }
}