package com.example.administrator.a20_jan_task

import android.arch.persistence.room.Room
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_add_contact.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        var OnClickDialogItem=0
        var Contact_=contactdetails()
        var ContactData = ArrayList<contactdetails>()
        lateinit var db: AppDb
        var id = 0
        fun updateList()
        {
            ContactData.clear()
            ContactData.addAll(db.postsDao().getAll())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        db = Room.databaseBuilder(
                this,
                AppDb::class.java,
                "ContactAppp").allowMainThreadQueries().fallbackToDestructiveMigration().build()



        updateList()



        add.setOnClickListener {
            startActivity(Intent(this,AddContact::class.java))
            overridePendingTransition(R.anim.slide_digonal,0)
        }


        contactslist.adapter=ContactsAdapter(ContactData,::OnClicked,::OnLongClicked)
        contactslist.layoutManager = LinearLayoutManager(this)
    }
    fun OnClicked(index:Int)
    {
        Contact_= ContactData[index]
        startActivity(Intent(this,ViewContact::class.java))
    }
    fun OnLongClicked(index:Int)
    {
        id=index
        Contact_= ContactData[index]
        val dialog = Option_Dialog(this,::OnClick)
        dialog.setCancelable(true)
        dialog.show()
    }
    fun OnClick()
    {
        if(OnClickDialogItem==0)
            contactslist.adapter?.notifyItemChanged(id)
        else if(OnClickDialogItem==1)
            startActivity(Intent(this,AddContact::class.java))
    }

}