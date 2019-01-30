package com.example.administrator.a20_jan_task

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_contact.*

class ViewContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact)

        contact_name_v.text=MainActivity.Contact_.Contact_Name
        contact_number_v.text=MainActivity.Contact_.Contact_Number.toString()
        contact_type_v.text=MainActivity.Contact_.Contact_Type
    }
}
