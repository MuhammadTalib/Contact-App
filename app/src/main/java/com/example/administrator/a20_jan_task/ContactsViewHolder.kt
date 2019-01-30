package com.example.administrator.a20_jan_task

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ContactsViewHolder(v:View):RecyclerView.ViewHolder(v)
{
    val Contact_Name:TextView=v.findViewById(R.id.contact_name)
    fun bind(item:contactdetails)
    {
        Contact_Name.text=item.Contact_Name
    }

}