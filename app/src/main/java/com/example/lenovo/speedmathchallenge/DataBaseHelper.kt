package com.example.lenovo.speedmathchallenge

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by lenovo on 10/2/18.
 */

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    companion object {

        // Table Name
        val TABLE_NAME = "PERSON"

        // Table columns
        val EMAIL = "email"
        val PASSWORD = "password"

        // Database Information
        internal val DB_NAME = "SPEEDMATH.DB"

        // database version
        internal val DB_VERSION = 1

        // Creating table query
        private val CREATE_TABLE = ("create table " + TABLE_NAME + "(" + EMAIL
                + " TEXT PRIMARY KEY, " + PASSWORD
                + " TEXT NOT NULL);")
    }
}

