package com.example.administrator.a20_jan_task
import android.arch.persistence.room.TypeConverter
import android.graphics.Bitmap
import com.google.gson.Gson
import java.io.ByteArrayOutputStream
import java.util.*

class MyTypeConverter{

    @TypeConverter
    fun strArrayToString(value:Array<String>):String{
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun stringToArray(value:String):Array<String>{
        val gson = Gson()
        return gson.fromJson(value,Array<String>::class.java)
    }
/*
    @TypeConverter
    fun bitmapToStr(value: Bitmap):String{
        val byteArrayOutputStream = ByteArrayOutputStream()
        value.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    @TypeConverter
    fun strToBitmap(value:String): Bitmap {
        val decodedString = Base64.decode(value, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    }*/
}