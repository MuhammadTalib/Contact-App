package com.example.administrator.a20_jan_task

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters


@Database(entities = [contactdetails::class],version = 2)
@TypeConverters(MyTypeConverter::class)
abstract class AppDb : RoomDatabase(){
    abstract fun postsDao():ContactdetailsDao
}