package com.example.administrator.a20_jan_task

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.TextView

class Dialog_view_holder(v: View):RecyclerView.ViewHolder(v)
{
    var mytext:TextView=v.findViewById(R.id.text)
    var checkbox:CheckBox=v.findViewById(R.id.select)
    fun bind(item:String)
    {
        mytext.text=item
    }
}