package com.example.weaak9.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weaak9.R
import com.example.weaak9.model.realm.realmclass

class UserAdapter(val context: Context):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private  val users :MutableList<realmclass> = mutableListOf()

    inner class UserViewHolder (i : View) :RecyclerView.ViewHolder(i){
        val tvId :TextView = i.findViewById(R.id.idea)
        val tvNama : TextView = i.findViewById(R.id.name)
        val tvEmail :TextView = i.findViewById(R.id.email)
        fun bindview(u : realmclass){
            tvId.text = u.getId().toString()
            tvNama.text = u.getNama()
            tvEmail.text = u.getEmail()
        }
    }
    fun setUser(data : List<realmclass>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.muser,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindview(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }
}