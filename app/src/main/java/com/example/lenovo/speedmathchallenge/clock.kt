package com.example.lenovo.speedmathchallenge

/**
 * Created by lenovo on 4/3/18.
 */
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import android.os.CountDownTimer
import java.util.Timer
import java.util.TimerTask
import android.widget.TextView
import android.app.Activity
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v7.widget.ButtonBarLayout
import com.google.firebase.database.*
open class clock : AppCompatActivity(){
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         var seconds = 60
        var minutes = 2


        val t = Timer()

        t.scheduleAtFixedRate(object : TimerTask() {

            override fun run() {
                Main2Activity().runOnUiThread {
                    val tv = findViewById<TextView>(R.id.time)
                    if(minutes > -1 && seconds > 0 ) {
                        tv.text = minutes.toString() + ":" + seconds.toString()
                        seconds -= 1

                        if (seconds == 0) {
                            tv.text = minutes.toString() + ":" + seconds.toString()

                            seconds = 60
                            minutes = minutes - 1

                        }
                    }
                    if(minutes <= -1 || seconds == 0) {
                        tv.text = "timeover"
                    }
                }
            }


        }, 0, 1000)
    }

}

