package com.example.administrator.a20_jan_task

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.DisplayMetrics
import android.view.Gravity
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.dialog_view.*
import kotlinx.android.synthetic.main.option_dialog_view.*


class Option_Dialog(var context: Activity, val OnClick:()->Unit) : Dialog(context){

    init {

        setContentView(R.layout.option_dialog_view)
        val display = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(display)

        window?.setBackgroundDrawable(ColorDrawable(android.R.color.transparent))
        window?.setGravity(Gravity.BOTTOM)
        window?.attributes?.windowAnimations = R.style.dialog_animation

        name.text=MainActivity.Contact_.Contact_Name

        delete.setOnClickListener {
            MainActivity.db.postsDao().delete(MainActivity.Contact_)
            MainActivity.updateList()
            dismiss()
            MainActivity.OnClickDialogItem=0
            OnClick()

        }
        edit.setOnClickListener {

            AddContact.UpdateId=MainActivity.Contact_.id
            MainActivity.OnClickDialogItem=1
            // AddContact.Contact=MainActivity.Contact_
            OnClick()
        }

    }



}