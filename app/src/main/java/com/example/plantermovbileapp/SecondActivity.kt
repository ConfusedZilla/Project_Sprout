package com.example.plantermovbileapp

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val firstFragment = FirstPlanter()
        val secondFragment = SecondPlanter()
        val fragButton1 = findViewById<Button>(R.id.fragbutton1)
        val fragButton2 = findViewById<Button>(R.id.fragbutton2)


        //Making the First Planter layout as default
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentedLayout, firstFragment)
            commit()
        }

        //Changing into First Planter layout
        fragButton1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentedLayout, firstFragment)
                commit()
            }
        }

        //Changing into Second Planter layout
        fragButton2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentedLayout, secondFragment)
                commit()
            }
        }


    }
}