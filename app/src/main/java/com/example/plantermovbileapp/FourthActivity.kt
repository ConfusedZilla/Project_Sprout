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

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val spIntervals3 = findViewById<Spinner>(R.id.spIntervals3)
        val time3 = findViewById<Button>(R.id.inputTime3);
        val showtime3 = findViewById<TextView>(R.id.showTime3);
        val savePlanter3 = findViewById<Button>(R.id.savePlanter3);

        //unfinished spinner
        spIntervals3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        time3.setOnClickListener {
            val currenttime = Calendar.getInstance()
            val startHours = currenttime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currenttime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                showtime3.setText("$hourOfDay: $minute")
            }, startHours, startMinute, true).show()
        }

        savePlanter3.setOnClickListener {

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