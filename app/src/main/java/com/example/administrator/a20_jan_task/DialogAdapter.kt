package com.example.administrator.a20_jan_task

import android.app.Dialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DialogAdapter(var data:ArrayList<String>, val OnclickCheckbox:(Int)->Unit):RecyclerView.Adapter<Dialog_view_holder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Dialog_view_holder
    {

        return Dialog_view_holder(LayoutInflater.from(p0.context).inflate(R.layout.dialog_recycler_list_view,p0,false))

    }

    override fun onBindViewHolder(p0: Dialog_view_holder, p1: Int)
    {
        p0.bind(data[p1])
        p0.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked)
                OnclickCheckbox(p1)
            
        }
    }

    override fun getItemCount(): Int =data.size


}