package com.example.plantermovbileapp

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import java.util.*

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val spIntervals2 = findViewById<Spinner>(R.id.spIntervals2)
        val time2 = findViewById<Button>(R.id.inputTime2);
        val showtime2 = findViewById<TextView>(R.id.showTime2);
        val savePlanter2 = findViewById<Button>(R.id.savePlanter2);

        //unfinished spinner
        spIntervals2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterview: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        time2.setOnClickListener {
            val currenttime = Calendar.getInstance()
            val startHours = currenttime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currenttime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                showtime2.setText("$hourOfDay: $minute")
            }, startHours, startMinute, true).show()
        }

        savePlanter2.setOnClickListener {

            Toast.makeText(this, "Settings are now configured", Toast.LENGTH_SHORT).show()
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.planter1 -> Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }

            R.id.planter2 -> Intent(this, ThirdActivity::class.java).also {
                startActivity(it)
            }

            R.id.planter3 -> Intent(this, FourthActivity::class.java).also {
                startActivity(it)
            }
        }
        return true
    }
}