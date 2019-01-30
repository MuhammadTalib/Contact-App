package com.example.administrator.a20_jan_task

import android.arch.persistence.room.Ignore


class Addressdetails(

    var type:String,
    var	House_No:String,
    var	Block:String,
    var	City:String,
    var	Country:String,
    var	Email:String

){
    constructor():this("","","","","",""){}
}
