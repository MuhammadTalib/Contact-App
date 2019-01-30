package com.example.administrator.a20_jan_task

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast

class ContactsAdapter(val data:ArrayList<contactdetails>,val OnContactClicked:(Int)->Unit,val OnLongContactClicked:(Int)->Unit):RecyclerView.Adapter<ContactsViewHolder>()
{

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactsViewHolder {
        val itemView  = LayoutInflater.from(p0.context).inflate(R.layout.contact_list_item,p0,false)
        return ContactsViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: ContactsViewHolder, p1: Int) {
        p0.bind(data[p1])
        p0.itemView.setOnClickListener {
            OnContactClicked(p1)
        }

        p0.itemView.setOnLongClickListener {
            OnLongContactClicked(p1)
            true
        }
    }

}