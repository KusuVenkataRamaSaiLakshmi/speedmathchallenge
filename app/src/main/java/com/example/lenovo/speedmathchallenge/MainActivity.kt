package com.example.lenovo.speedmathchallenge

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.R.id.start
import android.widget.Button
import android.widget.Toast
import com.example.lenovo.speedmathchallenge.LoginActivity
import com.example.lenovo.speedmathchallenge.R.string.previous
import com.example.lenovo.speedmathchallenge.R.string.Start

import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_start.setOnClickListener {
            val isLoggedIn = SessionManager(_context = this).isLoggedIn
            if (isLoggedIn == true) {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, Main2Activity::class.java)
                startActivity(intent)

            }
        }

    }
}






