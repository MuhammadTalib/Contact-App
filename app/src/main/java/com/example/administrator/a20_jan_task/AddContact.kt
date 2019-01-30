package com.example.administrator.a20_jan_task

import android.arch.persistence.room.Room
import android.content.Intent
import android.location.Address
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_contact.*


class AddContact : AppCompatActivity() {

    var Contact_Type_List= arrayListOf<String>("Mobile","Work","Home","Main","Work Fax","Home Fax","Pager","Other","Custom")
    var Address_Type_List= arrayListOf<String>("Home","Work","Other","Custom")
    var status:Int=0


    companion object
    {
        var Contact:contactdetails= contactdetails()
        var UpdateId:Int=0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        if(Contact.Contact_Name!="")
        {
            Name.setText(Contact.Contact_Name)
            Number.setText(Contact.Contact_Number)
            House_No.setText(Contact.Address.House_No)
            Street.setText(Contact.Address.Block)
            City.setText(Contact.Address.City)
            Country.setText(Contact.Address.Country)
            Email.setText(Contact.Address.Email)
        }

        done.setOnClickListener{

            if(Name.text.toString().isEmpty()){
                Name.error = "Please Enter Some Text!"
                return@setOnClickListener
            }
            Contact.Contact_Name=Name.text.toString()
            if(Number.text.toString().isEmpty()) Contact.Contact_Number=0 else Contact.Contact_Number=Integer.parseInt(Number.text.toString())

            if(House_No.text.toString().isEmpty()) Contact.Address.House_No="" else Contact.Address.House_No=House_No.text.toString()
            if(Street.text.toString().isEmpty()) Contact.Address.Block="" else Contact.Address.Block=Street.text.toString()
            if(City.text.toString().isEmpty()) Contact.Address.City="" else Contact.Address.City=City.text.toString()
            if(Country.text.toString().isEmpty())Contact.Address.Country="" else Contact.Address.Country=Country.text.toString()
            if(Email.text.toString().isEmpty())Contact.Address.Email="" else Contact.Address.Email=Email.text.toString()


            save(Contact)
            MainActivity.Contact_= Contact
            startActivity(Intent(this,ViewContact::class.java))

            Name.setText("")
            Number.setText("")
            House_No.setText("")
            Street.setText("")
            City.setText("")
            Country.setText("")
            Email.setText("")
        }

        contact_type_drop.setOnClickListener {

            status=1
            val dialog = CustomDialog(this,Contact_Type_List,::Change_w_r_t_dialog)
            dialog.setCancelable(true)
            dialog.show()
            contactType.text= Contact.Contact_Type

        }

        address_type_drop.setOnClickListener {

            status=0
            val dialog = CustomDialog(this,Address_Type_List,::Change_w_r_t_dialog)
            dialog.setCancelable(true)
            dialog.show()
            AddressType.text= Contact.Address.type

        }
        cancel.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(R.anim.slide_digonal_down,0)

        }

    }
    override fun onBackPressed()
    {
        startActivity(Intent(this,MainActivity::class.java))
        overridePendingTransition(R.anim.slide_digonal_down,0)
    }
    fun updateList()
    {
        MainActivity.ContactData.clear()
        MainActivity.ContactData.addAll(MainActivity.db.postsDao().getAll())
    }
    private fun save(text:contactdetails){
        if(UpdateId == 0)
        {
            MainActivity.db.postsDao().insert(contactdetails(Contact_Name = text.Contact_Name,Contact_Number=text.Contact_Number,Contact_Type=text.Contact_Type,Address=text.Address))
        }
        else
        {
            MainActivity.db.postsDao().update(contactdetails(UpdateId,Contact_Name = text.Contact_Name,Contact_Number=text.Contact_Number,Contact_Type=text.Contact_Type,Address=text.Address))
        }
        UpdateId = 0
        updateList()
    }
    fun Change_w_r_t_dialog(index:Int)
    {
        if(status==1)
        {
            Contact.Contact_Type=Contact_Type_List[index]
            contactType.text=Contact.Contact_Type
        }
        else if(status==0)
        {
            Contact.Address.type=Address_Type_List[index]
            AddressType.text=Contact.Address.type
        }
    }
}