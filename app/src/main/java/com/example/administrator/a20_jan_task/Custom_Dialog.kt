package com.example.administrator.a20_jan_task

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.LinearLayoutManager
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.dialog_recycler_list_view.*
import kotlinx.android.synthetic.main.dialog_view.*

class CustomDialog(var context: Activity ,var data:ArrayList<String>,val Change_w_r_t_dialog:(Int)->Unit) :Dialog(context){

    init {
        setContentView(R.layout.dialog_view)

        val display = DisplayMetrics()

        context.windowManager.defaultDisplay.getMetrics(display)

        window?.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
        window?.setGravity(Gravity.BOTTOM)
        window?.attributes?.windowAnimations = R.style.dialog_animation

        DialogList.adapter=DialogAdapter(data,::OnClickCheckbox)
        DialogList.layoutManager = LinearLayoutManager( context, LinearLayout.VERTICAL,false)

    }
    fun OnClickCheckbox(index:Int)
    {
        dismiss()
        Change_w_r_t_dialog(index)
    }


}