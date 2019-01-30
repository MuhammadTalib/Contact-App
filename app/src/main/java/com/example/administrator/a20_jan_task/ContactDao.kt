package com.example.administrator.a20_jan_task

import android.arch.persistence.room.*

@Dao
interface ContactdetailsDao {

    @Query("SELECT * FROM contactdetails WHERE Contact_Number = :id")
    fun getById(id:Int):contactdetails

    @Query("SELECT * FROM contactdetails ORDER BY Contact_Number DESC")
    fun getAll():List<contactdetails>

    @Insert
    fun insert(post: contactdetails)

    @Update
    fun update(post: contactdetails)

    @Delete
    fun delete(post:contactdetails)

    @Delete
    fun delete(post:List<contactdetails>)

}