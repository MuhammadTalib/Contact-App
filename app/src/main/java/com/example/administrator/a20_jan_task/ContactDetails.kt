package com.example.administrator.a20_jan_task

import android.arch.persistence.room.*

@Entity
data class contactdetails(

        @PrimaryKey(autoGenerate = true) var id:Int = 0,
        @ColumnInfo var Contact_Name:String="",
        @ColumnInfo var Contact_Number:Int=0,
        @ColumnInfo var Contact_Type:String=" Mobile",
        @Embedded(prefix = "address_") var	Address:Addressdetails= Addressdetails("","","","","","")

)