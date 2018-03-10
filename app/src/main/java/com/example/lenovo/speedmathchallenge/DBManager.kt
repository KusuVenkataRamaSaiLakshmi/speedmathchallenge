package com.example.lenovo.speedmathchallenge

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase

/**
 * Created by lenovo on 10/2/18.
 */



class DBManager(private val context: Context) {

    private var dbHelper: DatabaseHelper? = null

    private var database: SQLiteDatabase? = null

    @Throws(SQLException::class)
    internal fun open(): DBManager {
        dbHelper = DatabaseHelper(context)
        database = dbHelper!!.writableDatabase
        return this
    }

    fun close() {
        dbHelper!!.close()
    }

    fun insert(email: String, password: String) {
        val contentValue = ContentValues()
        contentValue.put(DatabaseHelper.EMAIL, email)
        contentValue.put(DatabaseHelper.PASSWORD, password)
        database!!.insert(DatabaseHelper.TABLE_NAME, null, contentValue)
    }

    fun fetch(): Cursor? {
        val columns = arrayOf<String>(DatabaseHelper.EMAIL, DatabaseHelper.PASSWORD)
        val cursor = database!!.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null)
        cursor?.moveToFirst()
        return cursor
    }

}