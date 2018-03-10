package com.example.lenovo.speedmathchallenge
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import android.os.CountDownTimer
import java.util.Timer
import java.util.TimerTask

import android.app.Activity
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.AppCompatRadioButton
import android.support.v7.widget.ButtonBarLayout
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import android.view.View
import com.example.lenovo.speedmathchallenge.R.string.*
import com.example.lenovo.speedmathchallenge.clock
import com.google.firebase.database.*


class Main2Activity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        //  button = findViewById(R.id.option1) as Button
//        button = findViewById(R.id.option2) as Button
//        button = findViewById(R.id.option3) as Button
//        button = findViewById(R.id.option4) as Button
        //textview = findViewById(R.id.plain_text_input) as TextView
        //setContentView(R.layout.activity_main2)
        var mMessageReference: DatabaseReference? = null
        mMessageReference = FirebaseDatabase.getInstance().getReference().child("question1").child("question")
        mMessageReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var value = dataSnapshot.getValue(Main2Activity::class.java)
                textview.setText(value.toString())
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onCancelled(databaseError: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    }
}

